package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.TttPO;

public interface TttBaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TttPO record);

    int insertSelective(TttPO record);

    TttPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TttPO record);

    int updateByPrimaryKey(TttPO record);
}