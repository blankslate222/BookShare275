package edu.sjsu.cmpe275.bookshare.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionLog {

	Logger log = Logger
			.getLogger(edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl.class
					.getName());

	// advice injected before the execution of readFile() method
	@Around(value = "execution(* edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl.get(..))")
	public Object logUserLogin(ProceedingJoinPoint jp) {
		
		
		Object result = null;
		String user = jp.getArgs()[0].toString();
		log.info("login attempt by user: "+user);
		
		try {
			result = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
