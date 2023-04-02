package com.isaguler.chatappdemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping("/")
    public ModelAndView chatPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chatpage");
        return modelAndView;
    }
}
