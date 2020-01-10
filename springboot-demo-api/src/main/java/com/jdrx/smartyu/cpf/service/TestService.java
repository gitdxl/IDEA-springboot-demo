package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.TestPO;
import com.jdrx.smartyu.cpf.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service
 * Created by generator on 2020-01-10.
 */
@Service
public class TestService{
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);
    @Autowired
    private TestDao testDao;



}