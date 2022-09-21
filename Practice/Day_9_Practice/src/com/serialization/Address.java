package com.serialization;

public class Address {
	
	private String temporary, permanent;
	
	public Address(String temporary, String permanent) {
		this.temporary = temporary;
		this.permanent = permanent;
	}

	public String getTemporary() {
		return temporary;
	}

	public String getPermanent() {
		return permanent;
	}
	
}
