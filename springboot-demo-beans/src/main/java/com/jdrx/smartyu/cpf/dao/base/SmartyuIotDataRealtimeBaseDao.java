package com.jdrx.smartyu.cpf.dao.base;

import com.jdrx.smartyu.cpf.beans.entity.SmartyuIotDataRealtimePO;

public interface SmartyuIotDataRealtimeBaseDao {
    int insert(SmartyuIotDataRealtimePO record);

    int insertSelective(SmartyuIotDataRealtimePO record);
}