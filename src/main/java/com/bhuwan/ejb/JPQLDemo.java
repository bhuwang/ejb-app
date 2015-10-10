/**
 * 
 */

package com.bhuwan.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.bhuwan.ejb.entities.Animal;
import com.bhuwan.ejb.entities.AnimalInfo;

/**
 * Java Persistence Query Language. Here you can find all the options to query database table values. Instead of query database table we
 * will be quering entities.
 * 
 * @author bhuwan
 */
public class JPQLDemo {

	/**
	 * Here we are trying to execute simple query. We will see how we can execute parameterized query.
	 * 
	 * @param em
	 */
	public static void simpleQuery(EntityManager em) {
		System.out.println("inside JPQLDemo#simpleQuery method.");
		TypedQuery<Animal> query = em.createQuery("select a from Animal a", Animal.class);
		List<Animal> animals = query.getResultList();
		for (Animal animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * Here we are trying to execute simple query. We will see how we can execute parameterized query.
	 * 
	 * @param em
	 */
	public static void parameterizedQuery(EntityManager em) {
		System.out.println("inside JPQLDemo#parameterizedQuery method.");
		// TypedQuery<Animal> query =
		// em.createQuery("select a from Animal a where a.totalNo < :num",
		// Animal.class);
		// query.setParameter("num", 15);
		TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.totalNo < ? and a.type = ?", Animal.class);
		query.setParameter(1, 15);
		query.setParameter(2, "Deer");
		List<Animal> animals = query.getResultList();
		for (Animal animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * Instead of getting whole object here we are trying to get part of object and we will see how we can do it.
	 * 
	 * @param em
	 */
	@SuppressWarnings("rawtypes")
	public static void selectPartOfObject(EntityManager em) {
		System.out.println("inside JPQLDemo#selectPartOfObject method.");
		Query query = em.createQuery("select type, totalNo from Animal a where a.totalNo < ? and a.type = ?");
		query.setParameter(1, 15);
		query.setParameter(2, "Deer");
		List animals = query.getResultList();
		for (Object animal : animals) {
			Object[] animalArray = (Object[]) animal;
			System.out.println("Animal Type: " + animalArray[0] + " ------ Total No: " + animalArray[1]);
		}
	}

	/**
	 * Instead of getting whole object here we are trying to get part of object and we will see how we can do it. Also instead of getting
	 * result in array object we will create a custom pojo to hold the query result.
	 * 
	 * @param em
	 */
	public static void selectPartWithCustomPojo(EntityManager em) {
		System.out.println("inside JPQLDemo#selectPartWithCustomPojo method.");
		TypedQuery<AnimalInfo> query =
				em.createQuery("select new com.bhuwan.ejb.entities.AnimalInfo(type, totalNo) from Animal where totalNo < ? and type = ?",
						AnimalInfo.class);
		query.setParameter(1, 15);
		query.setParameter(2, "Deer");
		List<AnimalInfo> animals = query.getResultList();

		for (AnimalInfo animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " ------ Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * Instead of getting whole object here we are trying to get part of object and we will see how we can do it.
	 * 
	 * Note: Named queries being specified in annotation form, gives JPA provider and opportunity to pre-process the query and can lead to
	 * faster results.
	 * 
	 * @param em
	 */
	public static void namedQueries(EntityManager em) {
		System.out.println("inside JPQLDemo#namedQueries method.");
		TypedQuery<Animal> query = em.createNamedQuery("Animal.simple", Animal.class);
		List<Animal> animals = query.getResultList();

		for (Animal animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " ------ Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * If you have millions of records then we can define the starting index and the max result the list can return. This will be very
	 * helpful in pagination.
	 * 
	 * @param em
	 */
	public static void paginationSupport(EntityManager em) {
		System.out.println("inside JPQLDemo#paginationSupport method.");
		TypedQuery<Animal> query = em.createNamedQuery("Animal.simple", Animal.class);
		query.setFirstResult(3);
		query.setMaxResults(3);
		List<Animal> animals = query.getResultList();

		for (Animal animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " ------ Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * No need of mapping the primary keys in SQL joins. We have already defined the column mapping through annotation. Simple join will
	 * work.
	 * 
	 * @param em
	 */
	public static void joinExplicitlyDefined(EntityManager em) {
		System.out.println("inside JPQLDemo#joinExplicitlyDefined method.");
		Query query = em.createQuery("select c.categoryType, a.totalNo from Category c join c.animals a");
		@SuppressWarnings("rawtypes")
		List animals = query.getResultList();

		for (Object animal : animals) {
			Object[] animalArray = (Object[]) animal;
			System.out.println("Animal totalNo: " + animalArray[1] + " ------ Category Type: " + animalArray[0]);
		}
	}

	/**
	 * No need to define join explicitly because it happens implicitly from the table mapping thru annotations. Note that it only works for
	 * single valued association.
	 * 
	 * @param em
	 */
	public static void joinSimple(EntityManager em) {
		System.out.println("inside JPQLDemo#joinSimple method.");
		Query query = em.createQuery("select a.category.categoryType, a.totalNo from Animal a");
		@SuppressWarnings("rawtypes")
		List animals = query.getResultList();

		for (Object animal : animals) {
			Object[] animalArray = (Object[]) animal;
			System.out.println("Animal totalNo: " + animalArray[1] + " ------- Category Type: " + animalArray[0]);
		}
	}

	/**
	 * If the you are joining the table with multi valued collections then you have to mention the join explicitly.
	 * 
	 * @param em
	 */
	public static void joinWithMultivaluesAssociation(EntityManager em) {
		System.out.println("inside JPQLDemo#joinSimple method.");
		Query query = em.createQuery("select a.type, f.name from Animal a JOIN a.foodItems f");
		@SuppressWarnings("rawtypes")
		List animals = query.getResultList();

		for (Object animal : animals) {
			Object[] animalArray = (Object[]) animal;
			System.out.println("Animal type: " + animalArray[0] + " ------ Food Name: " + animalArray[1]);
		}
	}

	/**
	 * <pre>
	 * Pattern Matching:
	 * _(underscore) means single character
	 * 
	 * %(percentage) means zero or more characters
	 * 
	 * BETWEEN AND IN works as per sql
	 * 
	 * IS NULL OR IS NOT NULL [for single valued association]
	 * 
	 * IS EMPTY OR IS NOT EMPTY [for multi-valued association]
	 * 
	 * Aggregate:
	 * 
	 * 1. AVG
	 * 2. COUNT
	 * 3. MAX
	 * 4. MIN
	 * 5. SUM
	 * </pre>
	 */
	public static void checkingEmpty(EntityManager em) {
		System.out.println("inside JPQLDemo#checkingEmpty method.");
		// TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.foodItems is empty", Animal.class);

		// Is empty will also work for single valued
		// TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.cage is not empty", Animal.class);

		// this query not work for me
		// TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.cage is null", Animal.class);

		// Is not null will not work for multi valued, you have to use is empty or is not empty
		TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.foodItems is empty", Animal.class);

		// if the result only returning single value then we can directly call:
		// query.getSingleResult()

		List<Animal> animals = query.getResultList();

		for (Animal animal : animals) {
			System.out.println("Animal Type: " + animal.getType() + " ------ Total No: " + animal.getTotalNo());
		}
	}

	/**
	 * Will see how group by and order by works.
	 * 
	 * Case when then when
	 * 
	 * @param em
	 */
	public static void grouAndOrder(EntityManager em) {
		System.out.println("inside JPQLDemo#grouAndOrder method.");
		// Query query = em.createQuery("select a.category.categoryType, sum(a.totalNo) from Animal a group by a.category");

		// you can directly group by entity
		Query query = em.createQuery("select c.categoryType, sum(a.totalNo) from Category c join c.animals a group by c");
		@SuppressWarnings("rawtypes")
		List animals = query.getResultList();

		for (Object animal : animals) {
			Object[] animalArray = (Object[]) animal;
			System.out.println("Sum Animals: " + animalArray[1] + " ------- Category Type: " + animalArray[0]);
		}
	}

	/**
	 * <pre>
	 * Concept of Locking: Optimistic and Pessimistic locking
	 * 
	 * Concurrent updates can lead to wrong data being stored
	 * 
	 * new column version is introduced for solution.
	 * 
	 * if the version no. of the field does not match the changes will not happen.
	 * 
	 * add version field of type int and annotate with version. JPA automatically take care of the version field.
	 * 
	 * see the example in staff table.
	 * 
	 * Not Covered: Criteria API
	 * 
	 * </pre>
	 */
}
