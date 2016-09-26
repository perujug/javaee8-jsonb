package io.eddumelendez.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JsonbSerializerTests {

	private Jsonb jsonb;

	@Before
	public void setup() {
		this.jsonb = JsonbBuilder.create();
	}

	@Test
	public void serializePerson() {
		Person person = new Person("Eddú", "Meléndez");
		person.setFullname("Eddú Meléndez");

		String json = this.jsonb.toJson(person);
		assertThat(json, is("{\"name\":\"Eddú\",\"lastName\":\"Meléndez\"}"));
	}

	@Test
	public void serializePersonWithNillable() {
		PersonNillable person = new PersonNillable("Eddú", "Meléndez");

		String json = this.jsonb.toJson(person);
		assertThat(json, is("{\"name\":\"Eddú\",\"lastName\":\"Meléndez\"," +
				"\"alias\":null}"));
	}

	@Test
	public void serializePersonTransient() {
		PersonTransient person = new PersonTransient();
		person.setFullname("Eddú Meléndez");

		String json = this.jsonb.toJson(person);
		assertThat(json, is("{}"));
	}

}
