package com.jfecm.accounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackAccountManagementApplication {

    @GetMapping("/")
    public String defaultMessage() {
        return "Spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(BackAccountManagementApplication.class, args);
    }

}
