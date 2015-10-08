/**
 * 
 */
package com.bhuwan.ejb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author bhuwan
 *
 */
@Entity
@Table(name = "cage")
public class Cage implements Serializable {
	private static final long serialVersionUID = 8827905810235320460L;

	@Id
	@TableGenerator(name = "cageIdGenerator", pkColumnName = "gen_name", pkColumnValue = "cage_id_gen", valueColumnName = "gen_value", table = "id_generator")
	@GeneratedValue(generator = "cageIdGenerator")
	@Column(name = "cage_id")
	private Integer cageId;

	@Column(name = "cage_no")
	private String cageNo;

	private String location;

	@OneToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	/**
	 * @return the cageId
	 */
	public Integer getCageId() {
		return cageId;
	}

	/**
	 * @param cageId
	 *            the cageId to set
	 */
	public void setCageId(Integer cageId) {
		this.cageId = cageId;
	}

	/**
	 * @return the cageNo
	 */
	public String getCageNo() {
		return cageNo;
	}

	/**
	 * @param cageNo
	 *            the cageNo to set
	 */
	public void setCageNo(String cageNo) {
		this.cageNo = cageNo;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal
	 *            the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
