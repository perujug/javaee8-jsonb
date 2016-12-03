package com.github.perujug.samples;

import javax.json.bind.annotation.JsonbAnnotation;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

@JsonbAnnotation
@JsonbPropertyOrder({"name", "lastName"})
public class Person {

	public Person(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public Person() {
	}

	private String name;

	@JsonbProperty(value = "lastName")
	private String lastname;

	@JsonbTransient
	private String fullname;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullname() {
		return this.name + " " + this.lastname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (!name.equals(person.name)) return false;
		return lastname.equals(person.lastname);

	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + lastname.hashCode();
		return result;
	}

}
