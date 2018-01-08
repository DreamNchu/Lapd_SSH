package com.lps.aop.writedata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lps.action.jsonresult.DataResult;

@Aspect
@Component
@Order(4)
public class WriteDataAspect {

	/**
	 * 前置通知：在某连接点之前执行的通知，但这个通知不能阻止连接点前的执行
	 * 
	 * @param jp
	 *            连接点：程序执行过程中的某一行为
	 */
	@Pointcut("execution(public java.lang.String com.lps.action..*.*())"
			+ "&&!execution(public java.lang.String com.lps.action..*.getResult())")
	private void myMethod() {
	}// 定义一个切入点

	public WriteDataAspect() {

	}
	
	private final Logger logger = LogManager.getLogger(this.getClass().getName());

	/**
	 * 方法执行完写入数据
	 * @param jp
	 */
	@After("myMethod()")
	public void doAfter(JoinPoint jp) {
		
		DataResult.basicMsg.writeInJsonData(DataResult.result); //写入数据
		DataResult.basicMsg.regress(); //复原
		
		String logStr = null;
		logStr =  "\n\n类名:------>" + jp.getTarget().getClass().getName() 
				+ "\n方法:------>" + jp.getSignature().getName()
				+ "\n数据:------>" + DataResult.result
				+ "\n";
		
		logger.info(logStr);
	}
}