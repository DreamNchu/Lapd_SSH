package com.lps.aop.check;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Pointcut("execution(* cn.com.cardinfo.merchantlink.service.*.*(..))")
	public void Controller() {
	}

	@Before("Controller()")
	public void beforeLog(JoinPoint jp) {
		jp.getArgs();
		// Object result = jp.proceed();
		System.out.println("log前");
	}

	@AfterReturning(pointcut = "Controller()", returning = "retVal")
	public void AfterreLog(JoinPoint jp, Object retVal) {
		Object object = null;
		object = jp.getThis();// 返回代理对象
		Object[] args = jp.getArgs();
		String logvalues = "";
		for (int i = 0; i < args.length; i++) {
			logvalues += "属性" + i + "::" + args[i].toString() + "--";
		}
		/* 切入点主体方法的名字 */
		String methodName = jp.getSignature().getName();
		String ClassName = jp.getTarget().getClass().toString();
		// 获取目标对象

		Object target = jp.getTarget();

		// 执行完方法的返回值：调用proceed（）方法，就会触发切入点方法执行

		if (retVal != null) {
			System.out.println(logvalues + "执行类:" + ClassName + "的方法:" + methodName + "()" + "执行成功;");
			// logger.fatal(logvalues+"执行类:"+ClassName+"的方法:"+methodName+"()"+"执行成功;");
		} else {
			System.out.println(logvalues + "执行类:" + ClassName + "的方法:" + methodName + "()" + "执行失败;");
			// logger.fatal(logvalues+"执行类:"+ClassName+"的方法:"+methodName+"()"+"执行失败;");
		}
	}

	@After(value = "Controller()")
	public void afterLog(JoinPoint jp) {
		Object object = null;
		object = jp.getThis();// 返回代理对象
		/* 切入点主体方法的名字 */
		String methodName = jp.getSignature().getName();
		System.out.println("方法:" + methodName + "()" + "成功执行;" + "登录成功!");
	}

	@AfterThrowing(value = "Controller()", throwing = "e")
	public void afterThrowing(JoinPoint jp, Throwable e) {
		System.out.println(jp.getSignature().getName() + ">>>>>异常" + e.getMessage());
	}

}
