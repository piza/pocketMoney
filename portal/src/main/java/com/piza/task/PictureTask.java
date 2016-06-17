package com.piza.task;

import com.piza.enums.ErrorTypeEnum;
import com.piza.model.DailyPicture;
import com.piza.service.DailyPictureService;
import com.piza.util.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Peter on 16/4/24.
 */

@Component("pictureTask")
public class PictureTask {

    @Autowired
    private DailyPictureService dailyPictureService;


    /**
     * 尝试抓取
     *
     * @param tryTime 尝试次数,不超过三次
     */
    public void tryCrawPicture(int tryTime) {
        if (tryTime >= 3) {
            return;
        }
        DailyPicture dailyPicture = new DailyPicture();
        try {
            Document htmlDoc = Jsoup.connect("http://photography.nationalgeographic.com/photography/photo-of-the-day").get();
            Element imgEl = htmlDoc.select(".primary_photo img").get(0);
            dailyPicture.setOriginUrl(imgEl.attr("src"));
            dailyPicture.setAlt(imgEl.attr("alt"));
            dailyPicture.setPublishTime(this.getText(htmlDoc, ".article_text .publication_time"));
            dailyPicture.setTitle(this.getText(htmlDoc, ".article_text h2"));
            String desc=this.getText(htmlDoc, ".article_text  #caption p:eq(2)");
            String desc2=this.getText(htmlDoc, ".article_text  #caption p:eq(3)");
            dailyPicture.setDescription(desc+"<br>"+desc2);
            dailyPicture.setCreateDate(new Date());
            this.dailyPictureService.insert(dailyPicture);
        } catch (IOException e) {
            e.printStackTrace();
            tryCrawPicture(tryTime++);
        }
    }

    @Scheduled(cron = "0 0 8 * * ?")
//@Scheduled(cron="0 15 17 * * ?")
    public void crawPicture() {
        tryCrawPicture(0);
    }

    private String getText(Document htmlDoc, String slt) {
        try {
            String str= htmlDoc.select(slt).get(0).text();
            return str == null? "":str;
        } catch (Exception e) {
            return "";
        }
    }


//    public static void main(String[] args) {
//        PictureTask pt=new PictureTask();
//        pt.tryCrawPicture(2);
//    }
}