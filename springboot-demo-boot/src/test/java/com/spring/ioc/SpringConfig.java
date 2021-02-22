package com.spring.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring.ioc")
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringConfig {
}
