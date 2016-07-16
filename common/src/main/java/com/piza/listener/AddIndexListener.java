package com.piza.listener;

import com.piza.enums.IndexTypeEnum;
import com.piza.events.AddIndexEvent;
import com.piza.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by Peter on 16/7/15.
 */
@Component
public class AddIndexListener implements ApplicationListener<AddIndexEvent> {



    @Async
    @Override
    public void onApplicationEvent(AddIndexEvent addIndexEvent) {
        switch(addIndexEvent.getIndexTypeEnum()){
            case DB_DATA:indexDbData(addIndexEvent);
            case FILE_DATA:indexFileData(addIndexEvent);
        }

    }
    private void indexDbData(AddIndexEvent addIndexEvent){
        Document document=new Document();
        Field idField=new IntField("dbId",addIndexEvent.getDbId(),Field.Store.YES);
        document.add(idField);
        Field typeField=new StringField("type",checkNull(addIndexEvent.getType()),Field.Store.YES);
        document.add(typeField);

        Field descField=new StringField("desc",getDesc(addIndexEvent.getTextContent()),Field.Store.YES);
        document.add(descField);

        Field contentField=new StringField("content",checkNull(addIndexEvent.getTextContent()),Field.Store.NO);
        document.add(contentField);

        LuceneUtil.getInstance().addDocument(document);


    }
    private void indexFileData(AddIndexEvent addIndexEvent){

    }

    private String checkNull(String s){
        return s == null?  "": s;
    }

    private String getDesc(String s){
       if(StringUtils.isEmpty(s)){
           return "";
       }

       if(s.length()>40){
           return s.substring(0,38);
       }
       return s;
    }
}
