import java.io.IOException;
import java.io.PrintWriter;

public class Test {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		
		Vehicle vehicle = new Vehicle("Ford","Green",4);
		
		out.println(vehicle.getName());
		out.println(vehicle.getColor());
		out.println(vehicle.getNumberOfWheels());
		out.println(vehicle.honk());
		
		Vehicle vehicle2 = vehicle.getObject();
		out.println(vehicle2.getName());
		
		
		Car car = new Car("Audi","Blue",4,80);
		
		out.println(car.getColor());
		out.println(car.getName());
		out.println(car.getNumberOfWheels());
		out.println(car.getNitro());
		out.println(car.honk());
		
		Car car2 = car.getObject();
		out.println(car2.getColor());
		
		
		Vehicle vehicle3 = new Car("BMW","Green",4,100);
		
		out.println(vehicle3.getColor());
		out.println(vehicle3.getName());
		out.println(vehicle3.getNumberOfWheels());
		out.println(((Car)vehicle3).getNitro());
		
		
		//abstract class could not be instantiated
		//Shape shape = new Shape();
		
		Square square = new Square(7);
		out.println(square.getArea());
		out.println(square.getSide());
		
		Circle circle = new Circle(6);
		out.println(circle.getRadius());
		out.println(circle.getArea());
		
		Triangle triangle = new Triangle(2,3);
		out.println(triangle.getBase());
		out.println(triangle.getHeight());
		out.println(triangle.getArea());
		
		
		//interfaces
		Snapdragon processor = new Snapdragon(650);
		out.println(processor.getModel());
		Sony camera = new Sony("A1");
		out.println(camera.getModel());
		
		SmartPhone smartphone = new SmartPhone(processor,camera);
		
		out.println(smartphone.makeCall());
		out.println(smartphone.sendMessage());
		out.println(smartphone.zoom());
		out.println(smartphone.setAlarm());
		out.println(smartphone.resolution());
		out.println(smartphone.takePhoto());
		out.println(smartphone.getCameraModel());
		out.println(smartphone.getProcessorModel());
		
		
		Processor processor2 = new Snapdragon(800);
		out.println(((Snapdragon)processor2).getModel());
		Camera camera2 = new Sony("A7R");
		out.println(((Sony)camera2).getModel());
		
		SmartPhone smartphone2 = new SmartPhone(processor2, camera2);
		
		out.println(smartphone2.makeCall());
		out.println(smartphone2.sendMessage());
		out.println(smartphone2.zoom());
		out.println(smartphone2.setAlarm());
		out.println(smartphone2.resolution());
		out.println(smartphone2.takePhoto());
		out.println(smartphone2.getCameraModel());
		out.println(smartphone2.getProcessorModel());
		
		
		
		
		out.close();
	}
}
