package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.BizWaterUserPO;

public interface BizWaterUserBaseDao {
    int deleteByPrimaryKey(Long id);

    int insert(BizWaterUserPO record);

    int insertSelective(BizWaterUserPO record);

    BizWaterUserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizWaterUserPO record);

    int updateByPrimaryKeyWithBLOBs(BizWaterUserPO record);

    int updateByPrimaryKey(BizWaterUserPO record);
}