package com.annotations;

public class Apple extends Computer{
	
	private String cpu;
	private int ram,hdd;
	
	public Apple(String cpu, int ram, int hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	@Override
	public String getCpu() {
		return cpu;
	}

	@Override
	public int getRam() {
		return ram;
	}
	
	@Override
	public int getHdd() {
		return hdd;
	}
	
}
