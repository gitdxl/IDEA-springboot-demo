package com.jdrx.springboot.demo.beans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserDTO",description="user数据传输对象")
public class UserDTO {
	@ApiModelProperty(name="id",value="用户id",required=true)
	Integer id;
	String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
