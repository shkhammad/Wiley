
public class Circle extends Shape{
	
	public Circle(double radius) {
		super(radius);
	}
	
	@Override
	public double getArea() {
		return Math.PI * super.getRadius() * super.getRadius();
	}
	
	public double getRadius() {
		return super.getRadius();
	}
}
