package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.SmartyuIotDataRealtimePO;
import com.jdrx.smartyu.cpf.dao.SmartyuIotDataRealtimeDao;
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
public class SmartyuIotDataRealtimeService{
    private static final Logger logger = LoggerFactory.getLogger(SmartyuIotDataRealtimeService.class);
    @Autowired
    private SmartyuIotDataRealtimeDao smartyuIotDataRealtimeDao;



}