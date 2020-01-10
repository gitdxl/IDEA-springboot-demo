package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.TestPO;

public interface TestBaseDao {
    int insert(TestPO record);

    int insertSelective(TestPO record);
}