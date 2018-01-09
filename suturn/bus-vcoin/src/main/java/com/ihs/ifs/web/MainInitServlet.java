package com.ihs.ifs.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * 系统初始化总控
 *
 */
public class MainInitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
//    private InitSys initSys;
	
	@Override
	public void init() throws ServletException {
		/*
		 * 加载Spring的Bean
		 */
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//		this.initSys = (InitSys)wac.getBean("init_initSys");
		
//		doInit();
//		startService();
	}

//	/**
//	 * 初始化参数、缓存、连接池等
//	 */
//	public void doInit() {
//		initSys.doInit();
//	}
//
//	/**
//	 * 启动后台服务
//	 */
//	public void startService() {
//		initSys.startService();
//	}
}
