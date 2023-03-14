package com.joyspring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

    public String port = System.getenv("PORT");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
