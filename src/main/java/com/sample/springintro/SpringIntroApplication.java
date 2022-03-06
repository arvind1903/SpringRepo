package com.sample.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sample.controller")
public class SpringIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroApplication.class, args);
    }

}
