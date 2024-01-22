package com.ob.tsb.accounts;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ob.tsb")
public class AccountsApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                AccountsApplication.class, args);
    }
}
