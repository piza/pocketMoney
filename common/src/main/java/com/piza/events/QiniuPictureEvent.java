package com.piza.events;

import com.piza.model.DailyPicture;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Peter on 16/5/11.
 */
public class QiniuPictureEvent extends ApplicationEvent {

    private DailyPicture dailyPicture;
    public QiniuPictureEvent(Object source) {
        super(source);
    }

    public DailyPicture getDailyPicture() {
        return dailyPicture;
    }

    public void setDailyPicture(DailyPicture dailyPicture) {
        this.dailyPicture = dailyPicture;
    }
}
