package com.piza.events;

import com.piza.enums.IndexTypeEnum;
import com.piza.model.DailyPicture;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Peter on 16/5/11.
 */
public class AddIndexEvent extends ApplicationEvent {

    private IndexTypeEnum indexTypeEnum;
    private Integer dbId;
    private String type;
    private String textContent;
    private String filePath;

    public AddIndexEvent(Object source) {
        super(source);
    }

    public IndexTypeEnum getIndexTypeEnum() {
        return indexTypeEnum;
    }

    public void setIndexTypeEnum(IndexTypeEnum indexTypeEnum) {
        this.indexTypeEnum = indexTypeEnum;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
