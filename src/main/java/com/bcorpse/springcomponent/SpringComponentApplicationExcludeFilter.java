package com.bcorpse.springcomponent;

import com.bcorpse.example.packageB.DemoBeanB1;
import com.bcorpse.example.packageB.DemoBeanB2;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = {DemoBeanB1.class},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                value = DemoBeanB2.class))
public class SpringComponentApplicationExcludeFilter {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(SpringComponentApplicationExcludeFilter.class,args);
        System.out.println("Contains A  " + context.containsBean("demoBeanA"));
        System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
        System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
    }
}
