package com.bhuwan.ejb.beans;

import javax.ejb.Local;

@Local
public interface SingletonExampleLocal {

	public void increment();

	public int getNumber();
}
