package com.lps.aop.check;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

//@Aspect
//@Component
//@Order(5)
//@Scope("request")
public class OnlineCheckIntercepter {
	
	private  HttpServletRequest request;  
	

	public HttpServletRequest getRequest() {
		return request;
	}

	@Autowired 
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	@Pointcut("execution(public * com.lps.action.operation..*.*())")
	public void myMethod(){}
	
	@Around("myMethod()")
	public Object checkAccess(ProceedingJoinPoint pjp) throws Throwable {
		if(request.getSession().getAttribute("id") == null){
			return Action.LOGIN;
		}
		Object retVal = pjp.proceed();
		return retVal;
	}

	
}

