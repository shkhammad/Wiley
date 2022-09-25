package com.dsa;

public class Pair implements Comparable<Pair>{
	private int index,value;
	
	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getValue() {
		return this.value;
	}
	
	//can be done by implementing comparable interface and overriding
	//compareTo method as well
	@Override
	public int compareTo(Pair pair) {
		
		if(this.getValue() < pair.getValue())
			return 1;
		
		else if(this.getValue() > pair.getValue())
			return -1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		return this.getIndex() + " " + this.getValue(); 
	}
	
}
