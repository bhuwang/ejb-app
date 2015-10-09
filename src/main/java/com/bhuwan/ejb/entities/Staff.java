package com.bhuwan.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.bhuwan.ejb.utils.Gender;

/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@Table(name = "staff")
@NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// TableGenerator is database agnostic implementation and it take care of the id generation part.
	@TableGenerator(name = "idTableGenerator", pkColumnName = "gen_name", pkColumnValue = "staff_id_gen", valueColumnName = "gen_value",
			table = "id_generator")
	@GeneratedValue(generator = "idTableGenerator")
	private int id;

	private String address;

	@Column(name = "NAME")
	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String tempaddress;

	@Column(name = "start_date")
	// Temporal determine whether we are going to save date with time, date
	// only, or time only
	@Temporal(TemporalType.DATE)
	private Date startDate;

	// for locking: to prevent data integrity
	@Version
	private int version;

	public Staff() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTempaddress() {
		return this.tempaddress;
	}

	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}