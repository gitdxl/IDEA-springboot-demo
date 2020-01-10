package com.jdrx.springboot.demo.serviceImpl;

import com.jdrx.smartyu.cpf.dao.UserDao;
import com.jdrx.springboot.demo.beans.entity.Address;
import com.jdrx.springboot.demo.beans.entity.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author DengXueLong
 * @Date 2018/3/30 13:58
 */
@Service
public class UserInfoService {
//    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    Address address;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public  void save(){
        UserPO po = new UserPO(null,"aa","1","1235555","111","1");
        userDao.insert(po);
        try {
            userInfoService.update();
        } catch (Exception e) {
        }
        int i = 1/0;
    }
    @Transactional(rollbackFor = Exception.class)
    public void update(){
        userDao.update(new UserPO(1,"aa11","1","1235555","111","1"));
        int i = 1/0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateTest(){
        List<Map<String,Object>> data = userDao.statCountForOne();
        userDao.update(new UserPO(1,"dxl","111","1235555","111","1"));
        new Thread(() -> {
            userInfoService.update();
        }).start();
    }

}
