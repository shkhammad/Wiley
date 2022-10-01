package com.annotations;

//Bill Pugh Singleton Lazy Implementation
public class Singleton {
	private Singleton(){}
	
	private static class Helper {
		private static final Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance() {
		return Helper.singleton;
	}
	
}
