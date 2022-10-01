package com.annotations;

public abstract class Computer {
	
	//abstract methods
	public abstract String getCpu();
	public abstract int getRam();
	public abstract int getHdd();
	
	@Override
	public String toString() {
		return this.getCpu() + " " + this.getRam() + " " + this.getHdd();
	}
	
}
