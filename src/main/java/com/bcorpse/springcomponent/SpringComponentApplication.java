package com.bcorpse.springcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bcorpse.example")
public class SpringComponentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringComponentApplication.class,args);
		//SpringApplication.run(SpringComponentApplication.class, args);

		System.out.println("Contains A  "+context.
				containsBeanDefinition("demoBeanA"));
		System.out.println("Contains B2  " + context.
				containsBeanDefinition("demoBeanB2"));
		System.out.println("Contains C   " + context.
				containsBeanDefinition("demoBeanC"));

		/*
		for (String name: context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		*/
	}
}
