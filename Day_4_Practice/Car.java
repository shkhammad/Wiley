import java.io.FileNotFoundException;

public class Car extends Vehicle{
	
	private int nitro;
	
	public Car(String name, String color, int number_of_wheels, int nitro) {
		super(name,color,number_of_wheels);
		this.nitro = nitro;
	}
	
	public int getNitro() {
		return this.nitro;
	}
	
	@Override
	public String honk() {
		return "Car honk !";
	}
	
	@Override
	public Car getObject() throws FileNotFoundException{
		return this;
	}
}
