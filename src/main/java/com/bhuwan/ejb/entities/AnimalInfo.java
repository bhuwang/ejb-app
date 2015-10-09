/**
 * 
 */
package com.bhuwan.ejb.entities;

/**
 * @author bhuwan
 *
 */
public class AnimalInfo {

	private String type;
	private Integer totalNo;

	public AnimalInfo(String type, Integer totalNo) {
		this.type = type;
		this.totalNo = totalNo;
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
}
