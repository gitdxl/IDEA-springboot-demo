package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.ScorePO;
import com.jdrx.smartyu.cpf.dao.ScoreDao;
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
public class ScoreService{
    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);
    @Autowired
    private ScoreDao scoreDao;



}