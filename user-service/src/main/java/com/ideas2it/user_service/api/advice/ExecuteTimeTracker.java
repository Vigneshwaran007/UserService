package com.ideas2it.user_service.api.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * ExecuteTimeTracker is used to execute custom time tracker annotation.
 * 
 * @author Vigneshwaran N
 */
@Aspect
@Component
public class ExecuteTimeTracker {

	Logger logger = org.slf4j.LoggerFactory.getLogger(ExecuteTimeTracker.class);

	/**
	 * trackTime method is used to create custom time tracker annotation
	 * implementation.
	 * 
	 * @param joinPoint
	 * @author Vigneshwaran N
	 */
	@Around("@annotation(com.ideas2it.user_service.api.advice.TimeTrackerAnnotation)")
	public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Method name is :->" + joinPoint.getSignature() + " Execution Time is :->" + (endTime - startTime));
		return obj;
	}

}
