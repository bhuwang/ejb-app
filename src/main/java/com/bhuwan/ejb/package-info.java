package com.bhuwan.ejb;

/*
 * <pre>
 * EJP [Entity Java Beans]:
 * 
 * Layers:
 * 1. Web Layers: Servlets, JSP, JSF
 * 2. Service Layer: EJB
 * 3. Data Layer: JPA
 * 
 * Why EJB?
 * 
 * Container provides some certain facilities to these EJBs out of the box: Security, Pooling, Transaction, Concurrency, Timers, Interceptors etc. 
 * 
 * Two Categories of EJBs:
 * 1. Session Beans
 * 2. Message Driven Beans(MDB): more related to JMS
 * 
 * Session Beans:
 * 1. Stateless
 * The container usually manage pool of beans. 
 * 
 * 2. Stateful
 * There is no pool of instances.
 * 
 * 3. Singleton
 * There will be a only one instance of the bean per application server. So some concurrency features are available.	
 * 
 * </pre>
 */

