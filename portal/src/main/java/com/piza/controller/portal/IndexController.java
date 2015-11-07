package com.piza.controller.portal;

import com.piza.controller.BaseController;
import com.piza.enums.ErrorTypeEnum;
import com.piza.util.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 15/9/20.
 */

@Controller
public class IndexController extends BaseController{

    @RequestMapping("/index")
    public ModelAndView index( ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "background", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> background(HttpServletRequest request) {
        Map<String,String> result=new HashMap<String, String>();
        String timestamp=DateUtil.getMM_dd(new Date());
        Object cachedRes=request.getServletContext().getAttribute("bg_cache_"+timestamp);
        if(cachedRes!=null){
            return successResult(cachedRes);
        }
        try {
            Document htmlDoc= Jsoup.connect("http://photography.nationalgeographic.com/photography/photo-of-the-day").get();
            Element imgEl=htmlDoc.select(".primary_photo img").get(0);
            result.put("imgUrl",imgEl.attr("src"));
            result.put("alt",imgEl.attr("alt"));
            result.put("publishTime",htmlDoc.select(".article_text .publication_time").get(0).text());
            result.put("title",htmlDoc.select(".article_text h2").get(0).text());
            result.put("desc",htmlDoc.select(".article_text [dir=ltr] span").get(0).text());
            request.getServletContext().setAttribute("bg_cache_"+timestamp,result);
        } catch (IOException e) {
            e.printStackTrace();
            return failedResult(ErrorTypeEnum.SERVER_ERROR,"connect error");
        }
        return successResult(result);
    }
}
