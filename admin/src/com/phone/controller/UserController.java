package com.phone.controller;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phone.entity.Users;
import com.phone.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login" , method = {RequestMethod.POST,RequestMethod.GET })
	public String login(@Valid Users user , BindingResult result) {
		return "user/login";
	}

	@RequestMapping(value="/add" , method = {RequestMethod.POST,RequestMethod.GET })
	public String addUser(Users user) {
		Date date = new Date();
		user.setUserId(UUID.randomUUID().toString());
		user.setCreateTime(date);
		user.setModifyTime(date);
		user.setStatus(1);
		userService.insertSelective(user);
        return "redirect:/login";
	}

	@RequestMapping(value="/query/{uid}")
	public String queryUser(@PathVariable String uid, ModelMap model){
		Users user  = new Users();
		user.setUserId(uid);
		user = userService.selectByPrimaryKey(user);
		model.addAttribute("User", user);
	    return "user/query";
	}

}
