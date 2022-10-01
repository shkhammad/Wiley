package com.annotations;

public class House {
	
	private int doors,windows,bedrooms;
	private String kitchen,furniture;
	private boolean falseCeiling;
	
	private House(HouseBuilder builder) {
		this.doors = builder.doors;
		this.windows = builder.windows;
		this.bedrooms = builder.bedrooms;
		this.kitchen = builder.kitchen;
		this.furniture = builder.furniture;
		this.falseCeiling = builder.falseCeiling;
	}
	
	public int getDoors() {
		return this.doors;
	}
	
	public int getWindows() {
		return this.windows;
	}
	
	public int getBedrooms() {
		return this.bedrooms;
	}
	
	public String getKitchen() {
		return this.kitchen;
	}
	
	public String getFurniture() {
		return this.furniture;
	}
	
	public boolean getFalseCeiling() {
		return this.falseCeiling;
	}	
	
	static class HouseBuilder {
		
		private int doors,windows,bedrooms;
		private String kitchen,furniture;
		private boolean falseCeiling;
		
		public HouseBuilder(int doors, int windows, int bedrooms) {
			this.doors = doors;
			this.windows = windows;
			this.bedrooms = bedrooms;
		}
		
		public HouseBuilder setKitchen(String kitchen) {
			this.kitchen = kitchen;
			return this;
		}
		
		public HouseBuilder setFurniture(String furniture) {
			this.furniture = furniture;
			return this;
		}
		
		public HouseBuilder setFalseCeiling(boolean falseCeiling) {
			this.falseCeiling = falseCeiling;
			return this;
		}
		
		public House getHouse() {
			return new House(this);
		}
		
	}
	
}
