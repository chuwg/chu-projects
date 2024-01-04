package com.tistory.roobistory.productclient2.service;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    String a = "aaaaaa";
    public String hello() {
        return "hello!! World~~"+a;
    }
}