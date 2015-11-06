package com.peter.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Peter on 15/9/20.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index( ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
}
