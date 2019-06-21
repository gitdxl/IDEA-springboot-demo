package com.jdrx.springboot.demo.beans.dao;


import org.springframework.stereotype.Repository;
import com.jdrx.springboot.demo.beans.entity.UserPO;
//@Repository
public interface UserDao {
	UserPO getById(Integer id);
	Integer insert(UserPO po);
	Integer update(UserPO po);
}
