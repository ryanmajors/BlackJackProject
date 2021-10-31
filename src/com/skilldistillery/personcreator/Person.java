package com.skilldistillery.personcreator;

public abstract class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setfName(String fName) {
		this.name = fName;
	}

	@Override
	public String toString() {
		return name;
	}

}
