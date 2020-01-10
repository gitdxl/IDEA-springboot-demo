package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.AaaaPO;

public interface AaaaBaseDao {
    int insert(AaaaPO record);

    int insertSelective(AaaaPO record);
}