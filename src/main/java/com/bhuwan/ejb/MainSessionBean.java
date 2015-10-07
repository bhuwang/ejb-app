/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bhuwan.ejb.entities.Staff;

/**
 *
 * @author bhuwan
 */
@Singleton
@LocalBean
@Startup
public class MainSessionBean {

	@PersistenceContext(name = "ejb_ds")
	EntityManager em;

	@PostConstruct
	public void mainMethod() {
		System.out
				.println("Inside MainSessionBean#mainMethod method............");
		add(em);
		// update(em);
		// select(em);
		// delete(em);
	}

	private static void add(EntityManager em) {
		System.out.println("Inside MainSessionBean#add method............");
		// create object
		Staff staff = new Staff();
		staff.setName("EJB - Bhuwan Gautam");
		staff.setAddress("Lamachaur - Pokhara");
		staff.setTempaddress("Kapan Kathmandu");
		// persist to db
		em.persist(staff);
	}

	private static void update(EntityManager em) {
		Staff staff = em.find(Staff.class, 3);
		staff.setName("Bhuwaneshwor Gautam");
		staff.setAddress("Kapan Kathmandu");
		staff.setTempaddress("Kapan Kathmandu");
		// update staff name
		// In the code below there is no merge. Working with Hibernate means
		// working with objects and states
		// em.merge(staff);
	}

	private static void select(EntityManager em) {
		Staff staff = em.find(Staff.class, 1);
		System.out.println("Staff Name: " + staff.getName());
	}

	private static void delete(EntityManager em) {
		Staff staff = em.find(Staff.class, 3);
		// delete from db
		em.remove(staff);
	}
}
