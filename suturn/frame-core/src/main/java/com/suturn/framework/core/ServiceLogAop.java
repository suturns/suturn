package com.suturn.framework.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suturn.framework.core.entity.ServiceOperationLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;

@Aspect
@Component
public class ServiceLogAop {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceLogAop.class);
	

	@Autowired
	private HttpServletRequest request;
	
	private String logId;
	
	/**
	 * 添加操作日志
	 * @author Administrator
	 * @version 创建时间：2017年1月11日下午4:20:21
	 * @param point 切面参数
	 * @param ol 注解
	 */
	@Before(value="execution(* *..service*..*(..))&&@annotation(ol)")
	public void beforeOperationLog(JoinPoint  point,ServiceOperationLog ol)
	{
		 try {
			 	//获取拦截的类
			 	//Object target = point.getTarget();
			 	//获得拦截的方法
			 	Signature signature = point.getSignature();
			 	MethodSignature methodSignature = (MethodSignature)signature;
			 	Class<?> clas = methodSignature.getDeclaringType();
			 	//获取的method是接口对象
			 	//Method method = methodSignature.getMethod();
			 	//实际的实现对象
			 	Method method = point.getTarget().getClass().getDeclaredMethod(signature.getName(), methodSignature.getParameterTypes());    
			 	
			 	//方法参数名

			 	//参数值
			 	StringBuffer sb = new StringBuffer();
			 	if (point.getArgs() !=  null && point.getArgs().length > 0) {  
		             for ( int i = 0; i < point.getArgs().length; i++) {
		            	 if(point.getArgs()[i] instanceof HttpServletRequest || point.getArgs()[i] instanceof HttpServletResponse)
		            	 {
		            		 continue;
		            	 }
		            	 if(point.getArgs()[i] instanceof Object[] || point.getArgs()[i] instanceof Collection)
		            	 {
		            		 sb.append(JSONArray.toJSONString(point.getArgs()[i])+",");
		            	 }
		            	 else
		            	 {
		            		 sb.append(JSONObject.toJSONString(point.getArgs()[i])+",");
		            	 }
		            }  
		        }  
			 	
		      }  catch (Exception e) {
		    	  e.printStackTrace();
		      }
	}
	/**
	 * 添加日志
	 * @author Administrator
	 * @version 创建时间：2017年1月11日下午4:18:46
	 * @param point 切面参数
	 * @param ol 注解
	 * @param ex 异常
	 */
	@AfterThrowing(value="execution(* *..service*..*(..))&&@annotation(ol)", throwing="ex")
    public void addLog(JoinPoint point,ServiceOperationLog ol,Exception ex)
	{
// 		SystemUserLogs log = new SystemUserLogs();
//		log.setId(logId);
//		log.setResult(4);
//		systemUserLogsMapper.update(log);
	}
	
	/**
	 * 获取操作类型
	 * @author Administrator
	 * @version 创建时间：2017年1月11日下午3:27:52
	 * @param clas 泛型类
	 * @param method 方法
	 * @return String 返回值
	 */
    public String getOperationType(Class<?> clas, Method method){
        
        //方法注解
    	//Annotation[] ann = method.getAnnotations();
//    	ServiceOperationLog operationLog = (ServiceOperationLog)method.getAnnotation(ServiceOperationLog.class);
//    	return operationLog.type().toString();
		return null;
    }
    
    /**
     * 获取IP
     * @author Administrator
     * @version 创建时间：2017年1月11日下午3:28:25
     * @return String 返回值
     */
    public String getIp()
    {
    	//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();  
        } 
		return ip;
    }

}
