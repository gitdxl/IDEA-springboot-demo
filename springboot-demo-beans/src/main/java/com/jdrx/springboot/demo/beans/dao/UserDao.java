package com.jdrx.springboot.demo.beans.dao;


import org.springframework.stereotype.Repository;
import com.jdrx.springboot.demo.beans.entity.UserPO;

import java.util.List;
import java.util.Map;

//@Repository
public interface UserDao {
	UserPO getById(Integer id);
	Integer insert(UserPO po);
	Integer update(UserPO po);

	List<Map<String,Object>> statCountForOne();
	List<Map<String,Object>> statCountForOneNoSet();
	List<Map<String,Object>> statCountForOneUseUnionAll();

	void testMultiSelect();

}
