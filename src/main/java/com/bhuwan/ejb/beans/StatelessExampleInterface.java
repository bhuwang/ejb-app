/**
 * 
 */
package com.bhuwan.ejb.beans;

import java.util.List;

import javax.ejb.Local;

import com.bhuwan.ejb.entities.Animal;

/**
 * @author bhuwan
 *
 */
@Local
public interface StatelessExampleInterface {

	String greetings(String name);

	List<Animal> getAllAnimals();
}
