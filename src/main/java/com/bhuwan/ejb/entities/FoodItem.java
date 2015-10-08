package com.bhuwan.ejb.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FoodItem
 *
 */
@Entity
@Table(name = "food_item")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "foodItemIdGenerator", pkColumnName = "gen_name", pkColumnValue = "food_item_id_gen", valueColumnName = "gen_value", table = "id_generator")
	@GeneratedValue(generator = "foodItemIdGenerator")
	private Integer food_item_id;

	private String name;

	private String quantity;

	@ManyToMany(mappedBy="foodItems")
	private List<Animal> animals;

	public FoodItem() {
		super();
	}

	public Integer getFood_item_id() {
		return this.food_item_id;
	}

	public void setFood_item_id(Integer food_item_id) {
		this.food_item_id = food_item_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the animals
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @param animals
	 *            the animals to set
	 */
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

}
