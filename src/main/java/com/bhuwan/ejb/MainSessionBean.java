/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bhuwan.ejb.entities.Animal;
import com.bhuwan.ejb.entities.Cage;
import com.bhuwan.ejb.entities.Category;
import com.bhuwan.ejb.entities.FoodItem;
import com.bhuwan.ejb.entities.Staff;
import com.bhuwan.ejb.utils.Gender;

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
		addOneToOne(em);
		addOneToMany(em);
		manyToMany(em);
		// update(em);
		// select(em);
		// delete(em);
	}

	private static void add(EntityManager em) {
		System.out.println("Inside MainSessionBean#add method............");
		// create object
		Staff staff = new Staff();
		staff.setName("EJB Enum - Bhuwan Gautam");
		staff.setAddress("Lamachaur - Pokhara");
		staff.setTempaddress("Kapan Kathmandu");
		staff.setGender(Gender.M);
		staff.setStartDate(new Date());
		// persist to db
		em.persist(staff);
	}

	private static void update(EntityManager em) {
		Staff staff = em.find(Staff.class, 3);
		staff.setName("Suman Shrestha");
		staff.setAddress("Morang Biratnagar");
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

	private static void addOneToOne(EntityManager em) {
		Animal animal = new Animal();
		animal.setType("Domestic Animal");
		animal.setTotalNo(23);

		Cage cage = new Cage();
		cage.setCageNo("C45");
		cage.setLocation("Kathmandu Jwalkhel");

		// Do not forget to hook both the side in bidirectional.
		cage.setAnimal(animal);
		animal.setCage(cage);

		// persist to db
		em.persist(animal);
		em.persist(cage);
	}

	private static void addOneToMany(EntityManager em) {
		Animal animal = new Animal();
		animal.setType("Buffalo 5");
		animal.setTotalNo(12);

		Category category = new Category();
		category.setCategoryType("Wild Animal 5");
		em.persist(category);

		// persist to db
		category = em.find(Category.class, 51);

		// set category
		animal.setCategory(category);
		em.persist(animal);
	}

	private static void manyToMany(EntityManager em) {
		List<FoodItem> items = new ArrayList<FoodItem>();
		FoodItem banana = new FoodItem();
		banana.setName("Banana");
		banana.setQuantity("12");
		em.persist(banana);

		FoodItem vegies = new FoodItem();
		vegies.setName("Vegies");
		vegies.setQuantity("8");
		em.persist(vegies);

		items.add(banana);
		items.add(vegies);

		Animal animal = new Animal();
		animal.setType("Deer");
		animal.setTotalNo(12);

		// set category
		animal.setFoodItems(items);
		em.persist(animal);
	}
}
