package com.test.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//<context:component-scan base-package="com.test.spring" />

//@SpringBootApplication
//@ComponentScan(basePackages = "com.test.spring") //이게 원래 기본값
//@ComponentScan(basePackages = "com.test.controller") //이렇게하면 별도로 다른 패키지에 있는 controller도 사용가능
//@ComponentScan(basePackages = "com.test.service")	   //사이드패키지 인식이 가능해짐
//@ComponentScan(basePackages = "com.test.repository")
//@ComponentScan(basePackages = {"com.test.controller", "com.test.service", "com.test.repository"})
//@ComponentScan(basePackages = "com.test.*")

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.controller", "com.test.repository"})
public class BootMybatisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BootMybatisApplication.class, args);
	}

}
