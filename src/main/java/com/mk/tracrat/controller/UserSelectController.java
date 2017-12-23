package com.mk.tracrat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.service.UserSelectService;

@RestController
public class UserSelectController {
	@Autowired
	private UserSelectService service;

	
}
