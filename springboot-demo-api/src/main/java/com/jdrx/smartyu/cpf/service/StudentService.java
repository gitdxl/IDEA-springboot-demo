package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.StudentPO;
import com.jdrx.smartyu.cpf.dao.StudentDao;
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
public class StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentDao studentDao;



}