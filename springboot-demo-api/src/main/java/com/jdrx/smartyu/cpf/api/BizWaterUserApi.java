package com.jdrx.smartyu.cpf.api;

import com.jdrx.smartyu.cpf.service.BizWaterUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 控制器
* Created by generator on 2020-01-10.
*/
@RestController
@RequestMapping(value = "/api/0/bizWaterUser")
@Api(value = "",tags = "控制器")
public class BizWaterUserApi{
private static final Logger logger = LoggerFactory.getLogger(BizWaterUserApi.class);
@Autowired
private BizWaterUserService bizWaterUserService;

public void say(){}


}