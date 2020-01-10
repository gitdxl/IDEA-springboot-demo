package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.AaaaPO;
import com.jdrx.smartyu.cpf.dao.AaaaDao;
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
public class AaaaService{
    private static final Logger logger = LoggerFactory.getLogger(AaaaService.class);
    @Autowired
    private AaaaDao aaaaDao;



}