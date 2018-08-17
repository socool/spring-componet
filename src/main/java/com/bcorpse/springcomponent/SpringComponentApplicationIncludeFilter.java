package com.bcorpse.springcomponent;

import com.bcorpse.example.packageB.DemoBeanB2;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.bcorpse.example.packageA", "com.bcorpse.example.packageB"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DemoBeanB2.class),
        useDefaultFilters = false)
public class SpringComponentApplicationIncludeFilter {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(SpringComponentApplicationIncludeFilter.class,args);
        System.out.println("Contains A  " + context.containsBean("demoBeanA"));
        System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
        System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
        System.out.println("Contains B3  " + context.containsBean("demoBeanB3"));
    }
}
