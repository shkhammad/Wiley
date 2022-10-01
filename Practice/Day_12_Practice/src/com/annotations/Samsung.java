package com.annotations;

public class Samsung extends Computer{
	
	private String cpu;
	private int ram,hdd;
	
	public Samsung(String cpu, int ram, int hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	@Override
	public String getCpu() {
		return this.cpu;
	}
	
	@Override
	public int getRam() {
		return this.ram;
	}
	
	@Override
	public int getHdd() {
		return this.hdd;
	}
	
}
