
public class Circle {
	int radius;
	double area;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double calculateArea() {
		area = Math.PI * this.radius * this.radius;
		return area;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
}
