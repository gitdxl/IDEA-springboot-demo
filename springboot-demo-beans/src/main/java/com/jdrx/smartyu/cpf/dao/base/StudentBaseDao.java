package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.StudentPO;

public interface StudentBaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentPO record);

    int insertSelective(StudentPO record);

    StudentPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentPO record);

    int updateByPrimaryKey(StudentPO record);
}