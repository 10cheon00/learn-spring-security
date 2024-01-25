package com.learn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/sample")
    @ResponseBody
    public String sampleAdminPage() {
        return "this is sample admin page.";
    }
}
