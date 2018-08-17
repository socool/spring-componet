package com.bcorpse.springcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.bcorpse.example.packageA",
        useDefaultFilters = false)
public class SpringComponentApplicationDisablingDefaultFilters {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(SpringComponentApplicationDisablingDefaultFilters.class,args);
        System.out.println("Contains A  " + context.containsBean("demoBeanA"));

    }
}
