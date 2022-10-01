package com.annotations;

public class ComputerFactory {
	public static Computer getComputer(String type, String cpu, int ram, int hdd) {
		
		if(type.equalsIgnoreCase("Samsung")) return new Samsung(cpu,ram,hdd);
		
		else if(type.equalsIgnoreCase("Apple")) return new Apple(cpu,ram,hdd);
		
		return null;
	}
}
