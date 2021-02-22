package com.spring.ioc;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void say() {
        System.out.println("say....");
    }
}
