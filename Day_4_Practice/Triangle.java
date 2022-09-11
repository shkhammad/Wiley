
public class Triangle extends Shape{
	
	public Triangle(double base, double height) {
		super(base,height);
	}
	
	@Override
	public double getArea() {
		return 0.5 * super.getWidth() * super.getHeight();
	}
	
	public double getBase() {
		return super.getWidth();
	}
	
	public double getHeight() {
		return super.getHeight();
	}
	
	
	
}
