package com.annotations;

public class Director {
	
	public House getHouseWithTeakFurnitureGalleryKitchen() {
		
		return new House.HouseBuilder(2,4,1).setKitchen("Gallery")
				.setFurniture("Teak").setFalseCeiling(false).getHouse();	
	}
	
	public House getHouseWithCottageFurnitureIslandKitchen() {
		
		return new House.HouseBuilder(2,2,6).setKitchen("Island")
				.setFurniture("Cottage").setFalseCeiling(true).getHouse();	
	}
	
	public House getHouseWithCaneFurnitureParallelKitchen() {
		
		return new House.HouseBuilder(2,3,3).setKitchen("Parallel")
				.setFurniture("Cane").setFalseCeiling(true).getHouse();	
	}
}
