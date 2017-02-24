package com.github.perujug.samples;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class JsonbDeserializerTest {

	private Jsonb jsonb;

	@Before
	public void setup() {
		this.jsonb = JsonbBuilder.create();
	}

	@Test
	public void deserializePerson() {
		String json = "{\"name\":\"Eddú\",\"lastName\":\"Meléndez\",\"fullname\":\"Eddú Meléndez\"}";

		Person me = new Person("Eddú", "Meléndez");

		Person person = this.jsonb.fromJson(json, Person.class);

		assertThat(me, is(person));
	}

	@Test
	public void deserializePersonTransient() {
		String json = "{\"fullname\":\"Eddú Meléndez\"}";

		PersonTransient person = this.jsonb.fromJson(json, PersonTransient.class);

		assertThat(person.getFullname(), is(nullValue()));
	}

}
