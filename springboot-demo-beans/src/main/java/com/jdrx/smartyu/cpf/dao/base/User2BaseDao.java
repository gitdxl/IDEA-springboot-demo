package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.User2PO;

public interface User2BaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User2PO record);

    int insertSelective(User2PO record);

    User2PO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2PO record);

    int updateByPrimaryKey(User2PO record);
}