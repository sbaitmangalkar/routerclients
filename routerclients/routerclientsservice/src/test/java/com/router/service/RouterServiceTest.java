package com.router.service;

import org.junit.Before;
import org.junit.Test;

import com.router.model.RouterInfo;

public class RouterServiceTest {
	private RouterInfo loginInfo;
	private RouterService routerService;
	
	@Before
	public void init(){
		String url = "http://192.168.0.1/login.htm";
		String userName = "Admin";
		String password = " ";
		
		loginInfo = new RouterInfo();
		routerService = new RouterService();
		
		loginInfo.setUrl(url);
		loginInfo.setUserName(userName);
		loginInfo.setPassword(password);
	}
	
	@Test
	public void testLogin(){
		routerService.login(loginInfo);
	}
}
