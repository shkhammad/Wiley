package com.annotations;

public class Test {

	public static void main(String[] args) {
		
		House house1 = new House.HouseBuilder(2,3,4)
				.setKitchen("Modular").setFurniture("Antique")
				.setFalseCeiling(true).getHouse();
		
		System.out.println("Doors: " + house1.getDoors());
		System.out.println("Windows: " + house1.getWindows());
		System.out.println("Bedrooms: " + house1.getBedrooms());
		System.out.println("Kitchen: " + house1.getKitchen());
		System.out.println("Furniture: " + house1.getFurniture());
		System.out.println("False Ceiling: " + house1.getFalseCeiling());
		
		
		House house2 = new House.HouseBuilder(2,5,6)
				.setKitchen("Basic").setFurniture("Modern")
				.setFalseCeiling(true).getHouse();
		
		System.out.println("Doors: " + house2.getDoors());
		System.out.println("Windows: " + house2.getWindows());
		System.out.println("Bedrooms: " + house2.getBedrooms());
		System.out.println("Kitchen: " + house2.getKitchen());
		System.out.println("Furniture: " + house2.getFurniture());
		System.out.println("False Ceiling: " + house2.getFalseCeiling());
		
		Director director = new Director();
		
		House house3 = director.getHouseWithTeakFurnitureGalleryKitchen();
		
		System.out.println("Doors: " + house3.getDoors());
		System.out.println("Windows: " + house3.getWindows());
		System.out.println("Bedrooms: " + house3.getBedrooms());
		System.out.println("Kitchen: " + house3.getKitchen());
		System.out.println("Furniture: " + house3.getFurniture());
		System.out.println("False Ceiling: " + house3.getFalseCeiling());
		
		
		House house4 = director.getHouseWithCottageFurnitureIslandKitchen();
		
		System.out.println("Doors: " + house4.getDoors());
		System.out.println("Windows: " + house4.getWindows());
		System.out.println("Bedrooms: " + house4.getBedrooms());
		System.out.println("Kitchen: " + house4.getKitchen());
		System.out.println("Furniture: " + house4.getFurniture());
		System.out.println("False Ceiling: " + house4.getFalseCeiling());
		
		
		
	}

}
