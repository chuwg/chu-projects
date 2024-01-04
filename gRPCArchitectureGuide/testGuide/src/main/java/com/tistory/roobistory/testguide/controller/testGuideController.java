package com.tistory.roobistory.testguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testGuideController {
    @GetMapping("/hello")
    public String hello() {
        return "hello World!";
    }
}