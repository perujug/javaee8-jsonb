package com.github.perujug.samples;

import javax.json.bind.annotation.JsonbAnnotation;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbAnnotation
@JsonbPropertyOrder({"name", "lastname", "alias"})
public class PersonNillable {

	public PersonNillable(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public PersonNillable() {
	}

	private String name;

	@JsonbProperty(value = "lastName")
	private String lastname;

	@JsonbProperty(nillable = true)
	private String alias;

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

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonNillable person = (PersonNillable) o;

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
