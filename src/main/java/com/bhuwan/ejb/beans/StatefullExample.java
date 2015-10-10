package com.bhuwan.ejb.beans;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bhuwan.ejb.entities.Animal;

/**
 * Session Bean implementation class StatefullExample
 */
@Stateful
@LocalBean
public class StatefullExample implements StatefullExampleLocal {

	@PersistenceContext(unitName = "ejb_ds")
	EntityManager em;

	String animalType;
	Integer animalTotalNo;

	/**
	 * Default constructor.
	 */
	public StatefullExample() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAnimalType(String type) {
		this.animalType = type;

	}

	@Override
	public void setAnimalTotalNo(Integer totalNo) {
		this.animalTotalNo = totalNo;

	}

	@Override
	public void finish() {
		System.out.println("Inside StatefullExample#finish method.");
		Animal animal = new Animal();
		animal.setType(this.animalType);
		animal.setTotalNo(animalTotalNo);

		em.persist(animal);
		System.out.println("Saved to DB........");
	}

	@Override
	@Remove
	public void removeBean() {

	}

}
