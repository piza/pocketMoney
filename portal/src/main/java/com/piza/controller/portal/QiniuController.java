package com.piza.controller.portal;

import com.piza.enums.ErrorTypeEnum;
import com.piza.events.QiniuPictureEvent;
import com.piza.model.DailyPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Peter on 16/5/11.
 */

@Controller
@RequestMapping("/qiniu")
public class QiniuController extends BaseController{

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value="dailyPicture",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert( @RequestBody DailyPicture dailyPicture) {

        if(dailyPicture.getId()==null){
            return this.failedResult(ErrorTypeEnum.VALIDATE_ERROR,"参数错误");
        }
        QiniuPictureEvent qiniuPictureEvent=new QiniuPictureEvent(this);
        qiniuPictureEvent.setDailyPicture(dailyPicture);
        applicationContext.publishEvent(qiniuPictureEvent);
        return successResult("ok");
    }
}
