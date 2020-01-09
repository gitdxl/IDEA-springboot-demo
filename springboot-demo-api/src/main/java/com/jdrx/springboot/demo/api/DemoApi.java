package com.jdrx.springboot.demo.api;

import com.jdrx.springboot.demo.beans.dao.UserDao;
import com.jdrx.springboot.demo.beans.dto.UserDTO;
import com.jdrx.springboot.demo.beans.entity.UserPO;
import com.jdrx.springboot.demo.service.IUserInfoService;
import com.jdrx.springboot.demo.serviceImpl.UserInfoService;
import com.jdrx.springboot.demo.serviceImpl.UserInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ConfigurationProperties(prefix="user")
@Api(value="模块",description = "desc")
@RequestMapping("/opi/0/deom")
public class DemoApi {

	@Autowired
	UserDao userDao;
	@Autowired
	User user;
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	@Autowired
	UserInfoService userInfoServiceImpl1;
	@Autowired
    UserInfoService userInfoService;
	@Autowired
	IUserInfoService iUserInfoService1;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value="获取用户信息",notes = "notess")
	@RequestMapping(value="getUserInfo",method=RequestMethod.POST)
	public UserPO test1(@ApiParam(name="id",value="用户id",required=true) @RequestParam Integer id){
		System.out.println(user.getNamePrefix()+"------");
		return userDao.getById(id);
//		return "hello world!!!";
	}


	@ApiOperation(value="捕获数据库异常测试",notes = "notess")
	@RequestMapping(value="testDBException",method=RequestMethod.POST)
	public String testDBException(@ApiParam(name="id",value="用户id",required=true) @RequestParam Integer id) throws Exception {
        try {
            UserPO u = new UserPO(1,"111","df","df","","");
            userDao.insert(u);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("捕获到了数据库异常信息");
        }
        return "hello world!!!";
	}

	@ApiOperation(value="apiModelTest",notes = "必须传入用户id")
	@RequestMapping(value="/apiModelTest",method=RequestMethod.POST)
	@Transactional
	public String apiModelTest(@Valid @RequestBody @ApiParam(name="userDTO",value="userDTO的json字符串",required=true)UserDTO userDto){
		return userDto.getId()+"";
	}
	@ApiOperation(value = "redis测试")
	@RequestMapping(value="/redis/test",method = RequestMethod.POST)
	public String redisTest(){
		redisTemplate.boundValueOps("ping").set("value");
		return "zz";
	}

	@PostMapping("updateTest")
	public void updateTest(){
		userInfoServiceImpl1.updateTest();
	}


	@ApiOperation("jdk代理 保存用户")
	@PostMapping("saveUserWithJDK")
	public void saveUser(){
		userInfoServiceImpl1.save();
	}

    @ApiOperation("cglib代理 保存用户")
    @PostMapping("saveUserWithCGLIB")
    public void saveUser1(){
        userInfoService.save();
    }
}

