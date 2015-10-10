/**
 * 
 */
package com.bhuwan.ejb.app;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bhuwan.ejb.beans.StatefullExampleLocal;

/**
 * <pre>
 * This is a example of local client accessing the statefull bean. 
 * You can simply inject the statefull bean using @EJB annotation to statefull bean's interface. 
 * Client interacts with the beans using interface not the direct implementation. 
 * If you access a bean with new operator you will simply get the simple object instance and no feature provided by the container to it.
 * 
 * In statefull, its client responsibility to remove bean after it job gets done. 
 * For that we have used @Remove annotation to make sure it is removed after the last method call.
 * 
 * Note: It's not a good practice to inject a statefull bean to a singleton bean.
 * </pre>
 * 
 * @author bhuwan
 *
 */
@Singleton
@Startup
public class StatefullBeanRunner {

	@EJB
	StatefullExampleLocal statefullBean;

	@PostConstruct
	public void mainMethod() {
		System.out.println("Inside StatefullBeanRunner#mainMethod method.");
		statefullBean.setAnimalType("Kangaroo");
		statefullBean.setAnimalTotalNo(63);
		statefullBean.finish();
		System.out.println("Values saved to DB......................");
		// remove bean from the server
		statefullBean.removeBean();
	}
}
