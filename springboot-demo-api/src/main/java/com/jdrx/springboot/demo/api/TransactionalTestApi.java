package com.jdrx.springboot.demo.api;

import com.jdrx.springboot.demo.serviceImpl.TransactionalTestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("transactionalTestApi")
@RestController
@RequestMapping("/tta")
public class TransactionalTestApi {
    @Autowired
    TransactionalTestService tts;

    @PostMapping("t1")
    public String t1(){
        tts.testTransactional();
        return "";
    }
}
