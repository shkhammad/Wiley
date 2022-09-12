import java.io.IOException;

public class Vehicle {
	private String name,color;
	private int number_of_wheels;
	
	public Vehicle(String name, String color, int number_of_wheels) {
		this.name = name;
		this.color = color;
		this.number_of_wheels = number_of_wheels;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getNumberOfWheels() {
		return this.number_of_wheels;
	}
	
	public String honk() {
		return "Vehicle Honk !";
	}
	
	public Vehicle getObject() throws IOException{
		return this;
	}
	
}
