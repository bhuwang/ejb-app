package com.bhuwan.ejb.beans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

/**
 * Session Bean implementation class TimerBeanDemo
 */
@Stateless
@LocalBean
public class TimerBeanDemo {

	@Resource
	TimerService timer;

	/**
	 * Default constructor.
	 */
	public TimerBeanDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Example of Programatic timer
	 */
	public void startTimer() {
		ScheduleExpression sc = new ScheduleExpression().hour("*").minute("*").second("*");
		timer.createCalendarTimer(sc);
	}

	@Timeout
	public void progmaticTimerMethod() {
		// System.out.println("I am invoked by programatic timer method !!");
	}

}
