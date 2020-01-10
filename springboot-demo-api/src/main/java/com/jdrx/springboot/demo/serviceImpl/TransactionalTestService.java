package com.jdrx.springboot.demo.serviceImpl;

import com.jdrx.smartyu.cpf.dao.UserDao;
import com.jdrx.springboot.demo.beans.entity.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalTestService {
//    @Autowired
    UserDao userDao;
    @Autowired
    TransactionalTestService tts;
    @Transactional(rollbackFor = Exception.class,readOnly = true)
    public void testTransactional() {
        this.validInsert();
        try {
            tts.exceptionInsert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void validInsert() {//正常insert
        UserPO po = new UserPO(null, "test1111222", "nan", "1344", "1", "普通用户");
        userDao.insert(po);
    }
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class,readOnly = true)
    public void exceptionInsert() {//这里会抛出数据库异常：Column 'user_name' cannot be null
        UserPO po = new UserPO(null, "sss", "nan", "1344", "1", "普通用户");
        userDao.insert(po);
//        int i = 1/0;
        System.out.println("123");
    }


}
