
public abstract class Shape {
	
	private double radius,width,height;
	
	public Shape(double radius) {
		this.radius = radius;
	}
	
	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	
	public abstract double getArea();
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	
}
