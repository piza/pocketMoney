package com.piza.controller.portal;

import com.piza.enums.ErrorTypeEnum;
import com.piza.model.UserInfo;
import com.piza.model.UserInfoExample;
import com.piza.service.UserInfoService;
import com.piza.util.DateUtil;
import com.piza.util.ServletUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * Created by Peter on 15/9/20.
 */

@Controller
public class IndexController extends BaseController{


    @Autowired
    private UserInfoService userInfoService;

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
            result.put("publishTime",this.getText(htmlDoc,".article_text .publication_time"));
            result.put("title",this.getText(htmlDoc,".article_text h2"));
            result.put("desc",this.getText(htmlDoc,".article_text [dir=ltr] span"));
            request.getServletContext().setAttribute("bg_cache_"+timestamp,result);
        } catch (IOException e) {
            e.printStackTrace();
            return failedResult(ErrorTypeEnum.SERVER_ERROR,"connect error");
        }
        return successResult(result);
    }

    private String getText(Document htmlDoc,String slt){
        try{
            return htmlDoc.select(slt).get(0).text();
        }catch (Exception e){
            return "";
        }
    }

    @RequestMapping(value = "needlogin")
    @ResponseBody
    public Map<String,Object> needlogin() {
        return this.failedResult(ErrorTypeEnum.NEED_LOGIN,"请登录!");
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request,HttpServletResponse httpServletResponse,@RequestBody UserInfo userInfo) {

        UserInfoExample example=new UserInfoExample();
        if(!StringUtils.isEmpty(userInfo.getCurrentToken())){//通过token自动登录
            example.or().andCurrentTokenEqualTo(userInfo.getCurrentToken());
            List<UserInfo> userInfos=this.userInfoService.selectByExample(example);
            if(userInfos.size()==1){
                return successResult(userInfos.get(0));
            }else{
                return this.failedResult(ErrorTypeEnum.NOT_FOUND,"token失效!");
            }
        }
        if(StringUtils.isEmpty(userInfo.getAccount())|| StringUtils.isEmpty(userInfo.getPassword())){
            return this.failedResult(ErrorTypeEnum.VALIDATE_ERROR,"参数错误!");
        }

        UserInfo loginUser=null;

        example.or().andAccountEqualTo(userInfo.getAccount());
        List<UserInfo> userInfos=this.userInfoService.selectByExample(example);
        if(userInfos.size()==1){
            loginUser=userInfos.get(0);
            if(loginUser.getPassword().equals(userInfo.getPassword())){
                loginUser.setCurrentToken(UUID.randomUUID().toString());
                loginUser.setLastLoginTime(new Date());
                loginUser.setLastLoginIp(ServletUtil.getClientIpAddr(request));
                this.userInfoService.updateByPrimaryKeySelective(loginUser);

                Cookie cookie = new Cookie("token", loginUser.getCurrentToken());
                cookie.setMaxAge(604800);
                cookie.setPath("/");
                httpServletResponse.addCookie(cookie);
            }else{
                return this.failedResult(ErrorTypeEnum.VALIDATE_ERROR,"密码错误!");
            }
        }else{
            return this.failedResult(ErrorTypeEnum.VALIDATE_ERROR,"用户不存在!");
        }
        return successResult(loginUser);
    }
}
