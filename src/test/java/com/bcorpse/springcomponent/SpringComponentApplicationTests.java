package com.bcorpse.springcomponent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringComponentApplicationTests {
	@Autowired
	ApplicationContext context;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindBeanShouldReturnBean(){
		assertTrue("Should be find demoBeanA!",context.containsBeanDefinition("demoBeanA"));
		assertTrue("Should be find demoBeanB2!",context.containsBeanDefinition("demoBeanB2"));
		assertTrue("Should be find demoBeanC!",context.containsBeanDefinition("demoBeanC"));
	}

	@Test
	public void testFindMissingPackageShouldReturnBean(){
		ApplicationContext context = SpringApplication.run(SpringComponentApplicationWithComponentScan.class, new String[]{});
		System.out.println(context.containsBeanDefinition("demoBeanC"));
		assertTrue("Should be Contains A",context.containsBeanDefinition("demoBeanA"));
		assertTrue("Should be Contains B2",context.containsBeanDefinition("demoBeanB2"));
		assertFalse("Should be Contains C",context.containsBeanDefinition("demoBeanC"));
		assertTrue("Should be Contains D",context.containsBeanDefinition("demoBeanD"));
	}

}
