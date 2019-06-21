package com.jdrx.springboot.demo.serviceImpl;

import com.jdrx.springboot.demo.beans.dao.UserDao;
import com.jdrx.springboot.demo.beans.entity.UserPO;
import com.jdrx.springboot.demo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author DengXueLong
 * @Date 2018/3/30 13:58
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoServiceImpl userInfoServiceImpl;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public   void save(){
        UserPO po = new UserPO(null,"aa","1","1235555","111","1");
        userDao.insert(po);
        userInfoServiceImpl.update();
    }


    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void update(){
        userDao.update(new UserPO(1,"aa11","1","1235555","111","1"));
        int i = 1/0;
    }
}
