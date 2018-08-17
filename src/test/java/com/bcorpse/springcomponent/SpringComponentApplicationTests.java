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
		assertTrue("Contains A",context.containsBeanDefinition("demoBeanA"));
		assertTrue("Contains B2",context.containsBeanDefinition("demoBeanB2"));
		assertTrue("Contains C",context.containsBeanDefinition("demoBeanC"));
	}

	@Test
	public void testFindMissingPackageShouldReturnBean(){
		ApplicationContext context = SpringApplication.run(SpringComponentApplicationWithComponentScan.class, new String[]{});
		System.out.println(context.containsBeanDefinition("demoBeanC"));
		assertTrue("Contains A",context.containsBeanDefinition("demoBeanA"));
		assertTrue("Contains B2",context.containsBeanDefinition("demoBeanB2"));
		assertFalse("Contains C",context.containsBeanDefinition("demoBeanC"));
		assertTrue("Contains D",context.containsBeanDefinition("demoBeanD"));
	}

	@Test
	public void testDisableDefaultFiltersShouldnNotGetBean(){
		ApplicationContext context = SpringApplication.run(SpringComponentApplicationDisablingDefaultFilters.class, new String[]{});
		assertFalse(context.containsBean("demoBeanA"));
	}

	@Test
	public void testIncludeFilter(){
		ApplicationContext context = SpringApplication.
				run(SpringComponentApplicationIncludeFilter.class,new String[] {});
		assertFalse("Contains A",context.containsBean("demoBeanA"));
		assertFalse("Contains B1",context.containsBean("demoBeanB1"));
		assertTrue("Contains B2",context.containsBean("demoBeanB2"));
		assertTrue("Contains B3",context.containsBean("demoBeanB3"));
	}

	@Test
	public void testIncludeFilterTypeRegex(){
		ApplicationContext context = SpringApplication.
				run(SpringComponentApplicationFilterTypeRegex.class,new String[] {});
		assertTrue("Contains A",context.containsBean("demoBeanA"));
		assertFalse("Contains B1",context.containsBean("demoBeanB1"));
		assertTrue("Contains B2",context.containsBean("demoBeanB2"));
	}
}
