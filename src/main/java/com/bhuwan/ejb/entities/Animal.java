package com.bhuwan.ejb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Entity implementation class for Entity: Animal
 *
 */
@Entity
@Table(name = "animal")
@NamedQueries({ @NamedQuery(name = "Animal.findAll", query = "select a from Animal a"),
		@NamedQuery(name = "Animal.simple", query = "select a from Animal a ") })
public class Animal implements Serializable {
	private static final long serialVersionUID = -6680423925972669316L;

	@Id
	@TableGenerator(name = "animalIdGenerator", pkColumnName = "gen_name", pkColumnValue = "animal_id_gen", valueColumnName = "gen_value",
			table = "id_generator")
	@GeneratedValue(generator = "animalIdGenerator")
	@Column(name = "animal_id")
	private Integer animalId;

	private String type;

	@Column(name = "total_no")
	private Integer totalNo;

	@OneToOne(mappedBy = "animal")
	private Cage cage;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany
	@JoinTable(name = "animal_food_item", joinColumns = { @JoinColumn(name = "animal_id") }, inverseJoinColumns = { @JoinColumn(
			name = "food_item_id") })
	private List<FoodItem> foodItems;

	public Animal() {
		super();
	}

	@Override
	public String toString() {
		return "type: " + type + " totalNo: " + totalNo + " category: " + category.getCategoryType();
	}

	/**
	 * @return the animalId
	 */
	public Integer getAnimalId() {
		return animalId;
	}

	/**
	 * @param animalId
	 *            the animalId to set
	 */
	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the totalNo
	 */
	public Integer getTotalNo() {
		return totalNo;
	}

	/**
	 * @param totalNo
	 *            the totalNo to set
	 */
	public void setTotalNo(Integer totalNo) {
		this.totalNo = totalNo;
	}

	/**
	 * @return the cage
	 */
	public Cage getCage() {
		return cage;
	}

	/**
	 * @param cage
	 *            the cage to set
	 */
	public void setCage(Cage cage) {
		this.cage = cage;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the foodItems
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * @param foodItems
	 *            the foodItems to set
	 */
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}
