/**
 * 
 */
package com.bhuwan.ejb.app;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bhuwan.ejb.beans.SingletonExampleLocal;

/**
 * <pre>
 * This is a example of local client accessing the singleton bean. 
 * You can simply inject the singleton bean using @EJB annotation to singleton bean's interface. 
 * Client interacts with the beans using interface not the direct implementation. 
 * If you access a bean with new operator you will simply get the simple object instance and no feature provided by the container to it.
 * 
 * If the bean does not implement any interface then the bean is by default local ie. bean cannot be a remote bean. 
 * There is no need of @LocalBean annotation. 
 * 
 * Concurrency support is available for singleton bean.
 * 
 * Note: It's not a good practice to inject a statefull bean to a singleton bean.
 * </pre>
 * 
 * @author bhuwan
 *
 */
@Singleton
@Startup
public class SingletonBeanRunner {

	@EJB
	SingletonExampleLocal singletonBean;

	@PostConstruct
	public void mainMethod() {
		System.out.println("Inside SingletonBeanRunner#mainMethod method.");
		singletonBean.increment();
		singletonBean.increment();
		System.out.println("And the number is: " + singletonBean.getNumber());
	}
}
