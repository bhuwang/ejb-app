/**
 * 
 */
package com.bhuwan.ejb.app;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bhuwan.ejb.beans.StatelessExampleInterface;
import com.bhuwan.ejb.entities.Animal;

/**
 * <pre>
 * This is a example of local client accessing the stateless bean. 
 * You can simply inject the stateless bean using @EJB annotation to stateless bean's interface. 
 * Client interacts with the beans using interface not the direct implementation. 
 * If you access a bean with new operator you will simply get the simple object instance and no feature provided by the container to it.
 * </pre>
 * 
 * @author bhuwan
 *
 */
@Singleton
@Startup
public class StatelessBeanRunner {

	@EJB
	StatelessExampleInterface statelessBean;

	@PostConstruct
	public void mainMethod() {
		System.out.println("Inside StatelessBeanRunner#mainMethod method.");
		System.out.println(statelessBean.greetings("Bhuwan Gautam"));

		// get all animal list
		for (Animal animal : statelessBean.getAllAnimals()) {
			System.out.println("Animals: " + animal.toString());
		}
	}
}
