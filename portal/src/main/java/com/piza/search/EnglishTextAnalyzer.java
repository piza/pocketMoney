package com.piza.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.apache.lucene.analysis.core.LetterTokenizer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 16/5/22.
 */
public class EnglishTextAnalyzer {

//    private static Analyzer analyzer=new EnglishAnalyzer();
    private static Analyzer analyzer=new StandardAnalyzer();


    public static List<String> analyse(String english){
        List<String> resList=new ArrayList<String>();
        TokenStream tokenStream= null;
        try {
            tokenStream = analyzer.tokenStream(null, english);
            CharTermAttribute term =tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();
            while (tokenStream.incrementToken()){
                resList.add(term.toString());
                System.out.println(term.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resList;
    }

    public static void tokenizer(String english){
        AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
        try {
            AutoPhraseTokenizer tokenizer = new AutoPhraseTokenizer(factory);
//            Tokenizer tokenizer = new LetterTokenizer(factory);

            tokenizer.setReader(new StringReader(english));
            tokenizer.reset();
            CharTermAttribute term =tokenizer.addAttribute(CharTermAttribute.class);
            while (tokenizer.incrementToken()){
//                System.out.println(term.toString());
            }
            tokenizer.getPhraseProcess().process();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        System.out.println((int)'a');
        tokenizer("Photograph by Marja Schwartz, National Geographic Your Shot\n" +
                "An African lioness rests in the rosy light of the setting sun in Botswana’s Okavango Delta. Lionesses are the primary hunters of their pride, doing so usually at dawn, dusk, or night; however, some lions in the Okavango Delta have adapted to hunting during the day, timing their meals to the movement of the herds of Cape buffalo that also live there.");
    }
}
