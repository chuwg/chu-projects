package com.tistory.roobistory.productclient2.controller;
import com.tistory.roobistory.productclient2.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    String hello;

    // @Autowired
    HelloService helloService = new HelloService(); // 변수 선언
    @Autowired
    @GetMapping("/hello")
    public String hello() {
        //System.out.println(helloService.a);
        return helloService.hello();
    }
}