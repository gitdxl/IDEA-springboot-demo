package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.EmployeesPO;

public interface EmployeesBaseDao {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(EmployeesPO record);

    int insertSelective(EmployeesPO record);

    EmployeesPO selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(EmployeesPO record);

    int updateByPrimaryKey(EmployeesPO record);
}