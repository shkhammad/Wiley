package com.generics;

public class Generic<T> {
	
	private T type;
	
	public void add(T type) {
		this.type = type;
	}
	
	public T print() {
		return this.type;
	}
	
}
