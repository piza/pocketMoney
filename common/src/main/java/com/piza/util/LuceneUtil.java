package com.piza.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 16/7/15.
 */
public class LuceneUtil {

    private static LuceneUtil instance=null;

    private IndexSearcher indexSearcher;
    private IndexWriter writer=null;
    private  Analyzer analyzer;
    private String indexPath;

    private LuceneUtil(){
        analyzer = new SmartChineseAnalyzer();
         indexPath= SpringUtil.getConfigProperty("indexPath");
        initSeacher();
    }

    private void initSeacher(){
        try {
            IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
            indexSearcher = new IndexSearcher(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initWriter(){

        try {
            Path path=Paths.get(indexPath);
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(IndexWriterConfig.OpenMode.APPEND);
            if(!Files.exists(path)){
                Files.createDirectory(Paths.get(indexPath));
                iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            }
            Directory dir = FSDirectory.open(path);
            writer = new IndexWriter(dir, iwc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 单例,并且是第一次调用的时候初始化
     * @return
     */
    public static LuceneUtil getInstance(){
        if(instance==null){
            instance=new LuceneUtil();
        }
        return instance;
    }

    public void addDocument(Document document){
        try {
            initWriter();
            writer.addDocument(document);
            writer.close();
            initSeacher();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  List<Map<String,String>> search(String field,String srcStr){
        if(field==null){
            field="content";
        }
        List<Map<String,String>> documentList=new ArrayList<Map<String,String>>();
        try {
            srcStr=srcStr.replaceAll("\\*","");
            TokenStream tokenStream=analyzer.tokenStream(field, srcStr);
            QueryParser parser = new QueryParser(field, analyzer);
            Query query = parser.parse(parseQueryStr(tokenStream));
            TopDocs results = indexSearcher.search(query, 20);
            ScoreDoc[] hits = results.scoreDocs;
            for(ScoreDoc scoreDoc:hits){
                Map<String,String> result=new HashMap<String,String>();
                Document doc= indexSearcher.doc(scoreDoc.doc);
                result.put("desc", doc.get("desc"));
                retrieveData(result,doc,"dbId");
                retrieveData(result,doc,"type");
                retrieveData(result,doc,"filePath");
                documentList.add(result);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentList;
    }

    private void retrieveData(Map<String,String> result,Document doc,String key){
        String val=doc.get(key);
        if(val!=null){
            result.put(key,val);
        }
    }

    private static String parseQueryStr(TokenStream tokenStream){
        String qStr="";
        try{
            StringBuilder queryStr=new StringBuilder();
            CharTermAttribute term =tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();
            while (tokenStream.incrementToken()){
                queryStr.append(term.toString());
                queryStr.append("* AND ");
            }
            tokenStream.end();
            tokenStream.close();
            qStr =queryStr.toString();
            if(qStr.endsWith(" AND ")){
                qStr=qStr.substring(0,qStr.length()-5);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qStr;
    }


}
