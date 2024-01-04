package com.tistory.roobistory.javapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotorBikeRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaPracticeApplication.class, args);
        // MotorBike 의 인스턴스로 ducati 와 honda 생성.
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();
        ducati.speed = 100;
        honda.speed = 80;
        ducati.start();
        honda.start();

        // 연습문제 BookEx 클래스를 사용해서 인스턴스 3개 만들기.
        BookEx artOfComputerProgramming = new BookEx();
        BookEx effectiveJava = new BookEx();
        BookEx cleanCode = new BookEx();
    }

}

