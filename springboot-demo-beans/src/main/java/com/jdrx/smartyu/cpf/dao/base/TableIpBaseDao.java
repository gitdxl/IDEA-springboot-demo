package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.TableIpPO;

public interface TableIpBaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TableIpPO record);

    int insertSelective(TableIpPO record);

    TableIpPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableIpPO record);

    int updateByPrimaryKey(TableIpPO record);
}