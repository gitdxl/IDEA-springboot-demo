package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.User2PO;
import com.jdrx.smartyu.cpf.dao.User2Dao;
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
public class User2Service{
    private static final Logger logger = LoggerFactory.getLogger(User2Service.class);
    @Autowired
    private User2Dao user2Dao;



}