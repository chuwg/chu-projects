package com.tistory.roobistory.clientarchitectureguide.controller;

import com.tistory.roobistory.clientarchitectureguide.service.StubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    StubService stubService;

    @GetMapping("/productinfo")
    public String hello() {
        stubService.productInfoClient();
        return "hello world!"; // return 값을 넣고 싶지 않으면 String 대신 void 를 사용합니다.
    }
}
