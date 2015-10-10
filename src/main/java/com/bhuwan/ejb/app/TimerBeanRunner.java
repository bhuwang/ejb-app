package com.bhuwan.ejb.app;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bhuwan.ejb.beans.TimerBeanDemo;

/**
 * Session Bean implementation class TimerBeanRunner
 */
@Singleton
@LocalBean
@Startup
public class TimerBeanRunner {

	@EJB
	TimerBeanDemo timerBean;

	@PostConstruct
	public void mainMethod() {
		timerBean.startTimer();
	}

}
