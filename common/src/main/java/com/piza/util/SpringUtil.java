package com.piza.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by Peter on 15/8/7.
 */

@Component("springUtil")
@Lazy(false)
public class SpringUtil implements ApplicationContextAware {

    public static ApplicationContext applicationContext;
    private static Properties properties;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext=applicationContext;
        properties = (Properties) SpringUtil.applicationContext.getBean("configProperties");
    }

    public static String getConfigProperty(String key){
        String value="";
        try {
            if(properties.containsKey(key)){
                value= properties.getProperty(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

}
