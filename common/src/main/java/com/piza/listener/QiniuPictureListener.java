package com.piza.listener;

import com.piza.events.QiniuPictureEvent;
import com.piza.model.DailyPicture;
import com.piza.service.DailyPictureService;
import com.piza.util.JsonUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Peter on 16/5/11.
 */
@Component
public class QiniuPictureListener implements ApplicationListener<QiniuPictureEvent> {


    @Value("#{configProperties['qiniu_ACCESS_KEY']}")
    private String ACCESS_KEY;

    @Value("#{configProperties['qiniu_SECRET_KEY']}")
    private String SECRET_KEY;
    private final String bucketname = "dailypicture";

    @Autowired
    private DailyPictureService dailyPictureService;
    @Override
    @Async
    public void onApplicationEvent(QiniuPictureEvent qiniuPictureEvent) {
        DailyPicture dailyPicture=qiniuPictureEvent.getDailyPicture();
        DailyPicture dbPic=this.dailyPictureService.selectByPrimaryKey(dailyPicture.getId());
        String ext= FilenameUtils.getExtension(dbPic.getOriginUrl());
        File tempFile=new File("/tmp/"+ UUID.randomUUID().toString()+"."+ext);
        URL url= null;
        try {
            String origiUrl=dbPic.getOriginUrl();
            if(!origiUrl.startsWith("http")){
                origiUrl="http:"+origiUrl;
            }
            url = new URL(origiUrl);
            FileUtils.copyURLToFile(url,tempFile);
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager();

            Response res = uploadManager.put(tempFile.getAbsolutePath(), tempFile.getName(), getUpToken(auth));
            String bodyStr=res.bodyString();
            if(res.isOK()){
                HashMap resObj=JsonUtil.str2Obj(bodyStr,HashMap.class);
                dailyPicture.setSavedUrl(resObj.get("key").toString());
                this.dailyPictureService.updateByPrimaryKeySelective(dailyPicture);
                tempFile.delete();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(Auth auth){
        return auth.uploadToken(bucketname);
    }
//
//    public static void main(String[] args) {
//        HashMap resObj=JsonUtil.str2Obj("{\"hash\":\"FjpiYN3HVLA0qpDkzfAqPq_5EO3g\",\"key\":\"a59edc44-8ce3-4f24-8ab4-82fb4e9e5e0f.jpg\"}",HashMap.class);
//        System.out.println(resObj.get("key").toString());
//    }

}
