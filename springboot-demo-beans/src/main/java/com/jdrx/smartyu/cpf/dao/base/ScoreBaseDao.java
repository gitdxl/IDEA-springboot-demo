package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.ScorePO;

public interface ScoreBaseDao {
    int deleteByPrimaryKey(Integer scoreId);

    int insert(ScorePO record);

    int insertSelective(ScorePO record);

    ScorePO selectByPrimaryKey(Integer scoreId);

    int updateByPrimaryKeySelective(ScorePO record);

    int updateByPrimaryKey(ScorePO record);
}