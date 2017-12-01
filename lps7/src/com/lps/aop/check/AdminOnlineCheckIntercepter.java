package com.lps.aop.check;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Aspect
@Component
@Scope("request")
public class AdminOnlineCheckIntercepter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8111568893243947676L;
	
	private  HttpServletRequest request;  
	

	public HttpServletRequest getRequest() {
		return request;
	}

	@Autowired 
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	@Pointcut("execution(public * com.lps.action.admin.operation.*.*())")
	public void myMethod(){}

	
	@Around("myMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("doBasicProfiling_request");
		if(request.getSession().getAttribute("id") == null){
			return Action.NONE;
		}
		
		Object retVal = pjp.proceed();
		return retVal;
	}


	
}

