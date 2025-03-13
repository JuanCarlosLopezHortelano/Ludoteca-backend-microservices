package com.ccsw.tutorial_prestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TutorialPrestamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialPrestamoApplication.class, args);
    }

}
