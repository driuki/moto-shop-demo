package com.shop.springboot.demo.motoshopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shop.springboot.demo.motoshopdemo.*"})
public class MotoShopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoShopDemoApplication.class, args);
	}
	
}
