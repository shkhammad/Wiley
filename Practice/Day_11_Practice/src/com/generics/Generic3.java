package com.generics;

//bounded type parameters for more restrictiveness
//only number and its subclasses can access this class
public class Generic3 <T extends Number>{
	private T type;
	
	public Generic3(T type) {
		this.type = type;
	}
	
	public T getValue() {
		return this.type;
	}
	
}
