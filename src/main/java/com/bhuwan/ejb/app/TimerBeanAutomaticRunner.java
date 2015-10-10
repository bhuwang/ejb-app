package com.bhuwan.ejb.app;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class TimerBeanAutomaticRunner
 */
@Singleton
@LocalBean
public class TimerBeanAutomaticRunner {

	@Schedule(hour = "*", minute = "*", second = "*/3")
	public void timerMethod() {
		System.out.println("I am invoked !!");
	}

}
