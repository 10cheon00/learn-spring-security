package com.learn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MainPageController {

    @GetMapping("")
    @ResponseBody
    public String sampleAdminPage() {
        return "MainPage MainPage MainPage \nMainPage MainPage MainPage MainPage MainPage MainPage MainPage MainPage MainPage \nMainPage MainPage MainPage MainPage ";
    }

}
