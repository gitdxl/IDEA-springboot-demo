package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.JobGradesPO;

public interface JobGradesBaseDao {
    int insert(JobGradesPO record);

    int insertSelective(JobGradesPO record);
}