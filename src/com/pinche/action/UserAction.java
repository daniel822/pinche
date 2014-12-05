package com.pinche.action;


import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.pinche.model.User;
import com.pinche.service.UserService;
import com.pinche.util.JSONUtils;

@Controller
@Namespace("/user")
@ParentPackage("json-default") 
public class UserAction extends CommonAction {

	private User user;
	
	@Resource
	private UserService userServiceImpl;
	
	@Action(value="addUser",results={@Result(type="json")})
	public String addUser() throws IOException{
		int i = userServiceImpl.addUser(user);
		this.output(i);
		return null;
	}

	@Action(value="getUser",results={@Result(type="json")})
	public String getUserById() throws IOException{
		User user1 = userServiceImpl.getUser(user.getId());
		//需要转成json格式
		this.output(JSONUtils.toJSon(user1));
		return null;
	}
	
	@Action(value="delUser",results={@Result(type="json")})
	public String delUser() throws IOException{
		int i = userServiceImpl.delUser(user.getId());
		this.output(i);
		return null;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
