package com.jdrx.smartyu.cpf.service;

import com.jdrx.smartyu.cpf.beans.entity.TableIpPO;
import com.jdrx.smartyu.cpf.dao.TableIpDao;
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
public class TableIpService{
    private static final Logger logger = LoggerFactory.getLogger(TableIpService.class);
    @Autowired
    private TableIpDao tableIpDao;



}