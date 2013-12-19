package com.phone.aop;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.phone.entity.RequestLog;
import com.phone.service.RequestLogService;

@Component
@Aspect
@Order(value=1)
public class LogAdvice {
	private final BlockingQueue<RequestLog> queue = new LinkedBlockingQueue<RequestLog>();
	private int CPUS = Runtime.getRuntime().availableProcessors() +1;
	private final ExecutorService executorService = Executors.newScheduledThreadPool(CPUS);
	
	@Autowired
	private RequestLogService requestLogService;
	
	@Around("within (com.phone.controller..*)")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String className = null;
		String method = null;
		String requestArgs = null;
		long dealTime = 0L;
		Long time = 0L;
		Date date = new Date();
		try {
			Object [] args = pjp.getArgs();
			className = pjp.getTarget().getClass().getName();
			method = pjp.getSignature().getName();
			requestArgs = Arrays.toString(args);
		    time = System.currentTimeMillis();
			Object retVal = pjp.proceed();
			dealTime = System.currentTimeMillis() - time;
			return retVal;
		} catch (Exception e) {
			dealTime = System.currentTimeMillis() - time;
			return null;
		}finally{
			RequestLog log = new RequestLog();
			log.setRequestClass(className);
			log.setRequestMethod(method);
			log.setRequestArgs(requestArgs);
			log.setDealTime(dealTime);
			log.setId(UUID.randomUUID().toString());
			log.setRequestTime(date);
			queue.add(log);
			executorService.execute(new LoggerThread(queue,requestLogService));
		}
	}

}
