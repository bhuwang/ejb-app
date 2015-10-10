package com.bhuwan.ejb.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bhuwan.ejb.entities.Animal;

/**
 * Session Bean implementation class StatelessExample
 */
@Stateless
@LocalBean
public class StatelessExample implements StatelessExampleInterface {

	@PersistenceContext(unitName = "ejb_ds")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public StatelessExample() {
	}

	@Override
	public String greetings(String name) {
		return "Hello " + name;
	}

	@Override
	public List<Animal> getAllAnimals() {
		System.out.println("Inside method StatelessExample#getAllAnimals method.");
		TypedQuery<Animal> queryList = em.createNamedQuery("Animal.simple", Animal.class);
		return queryList.getResultList();
	}

	/**
	 * Lifecycle of stateless bean
	 * 
	 * Mainly two phases: a. Doesnot exist or b. method ready pool
	 */

	@PostConstruct
	public void setup() {
		System.out.println("Inside method StatelessExample#init method.");
		System.out.println("initializing.....................");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Inside method StatelessExample#cleanup method.");
		System.out.println("Destroying.....................");
	}
}
