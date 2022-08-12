package com.test.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		//해당 웹 애플리케이션(사이트)를 내장된 톰캣을 통해서 실행 상태로 만듬.
		SpringApplication.run(HelloApplication.class, args);
	}

}
