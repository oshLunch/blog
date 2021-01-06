package com.cos.reflect.controller;

import com.cos.reflect.anno.RequestMapping;

public class UserController {

	@RequestMapping(value = "/join")
	public String join() {
		System.out.println("join() 함수 호출됨");
		return "/";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("login() 함수 호출됨");
		return "/";
	}
	
	@RequestMapping(value = "/user")
	public String user() {
		System.out.println("user() 함수 호출됨");
		return "/";
	}
	
	@RequestMapping(value = "/hello")
	public String hello() {
		System.out.println("hello() 함수 호출됨");
		return "/";
	}
}
