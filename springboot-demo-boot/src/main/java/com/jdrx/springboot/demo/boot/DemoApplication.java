package com.jdrx.springboot.demo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.jdrx")
@EnableAutoConfiguration
@MapperScan("com.jdrx.springboot.demo.beans.dao")
@EnableSwagger2
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
