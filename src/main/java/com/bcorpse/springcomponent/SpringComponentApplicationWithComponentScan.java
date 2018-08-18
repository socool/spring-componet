package com.bcorpse.springcomponent;

import com.bcorpse.example.packageB.DemoBeanB1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"com.bcorpse.example.packageA",
		"com.bcorpse.example.packageD",
		"com.bcorpse.example.packageE"
},
		basePackageClasses = DemoBeanB1.class)
public class SpringComponentApplicationWithComponentScan {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.
				run(SpringComponentApplicationWithComponentScan.class, args);
		System.out.println("Contains A  " + context.containsBeanDefinition("demoBeanA"));
		System.out.println("Contains B2  " + context.containsBeanDefinition("demoBeanB2"));
		System.out.println("Contains C   " + context.containsBeanDefinition("demoBeanC"));
		System.out.println("Contains D   " + context.containsBeanDefinition("demoBeanD"));

	}
}
