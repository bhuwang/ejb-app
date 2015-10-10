package com.bhuwan.ejb.beans;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class SingletonExample
 */
@Singleton
@LocalBean
public class SingletonExample implements SingletonExampleLocal {

	@PersistenceContext(unitName = "ejb_ds")
	EntityManager em;

	int number;

	/**
	 * Default constructor.
	 */
	public SingletonExample() {
	}

	@Override
	public void increment() {
		this.number++;

	}

	@Override
	public int getNumber() {
		return this.number;
	}

}
