package com.github.perujug.samples;

import javax.json.bind.annotation.JsonbTransient;

public class PersonTransient {

	@JsonbTransient
	private String fullname;

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
