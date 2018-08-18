package com.bcorpse.springcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableAutoConfiguration
@ComponentScan(value = "com.bcorpse.example",useDefaultFilters = false, includeFilters = @ComponentScan.Filter
        (type = FilterType.REGEX, pattern = ".*[A2]"))
public class SpringComponentApplicationFilterTypeRegex {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.
                run(SpringComponentApplicationFilterTypeRegex.class,args);
        System.out.println("Contains A  " + context.containsBean("demoBeanA"));
        System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
        System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));

        /*
        String[] stringsCheck = new String[] {"demoBeanA","demoBeanB1","demoBeanB2","demoBeanB3","demoBeanC","demoBeanD"};
        for(String data:stringsCheck)
            System.out.println(data.matches(".*[A2]"));
        */
    }
}
