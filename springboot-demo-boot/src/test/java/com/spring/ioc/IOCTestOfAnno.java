package com.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestOfAnno {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl userService = (UserServiceImpl) context.getBean(UserServiceImpl.class);
        userService.say();
    }
}
