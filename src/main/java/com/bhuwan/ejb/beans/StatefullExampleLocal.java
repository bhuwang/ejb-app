package com.bhuwan.ejb.beans;

import javax.ejb.Local;

@Local
public interface StatefullExampleLocal {

	public void setAnimalType(String type);

	public void setAnimalTotalNo(Integer totalNo);

	public void finish();

	public void removeBean();

}
