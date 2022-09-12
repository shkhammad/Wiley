
public class Square extends Shape{
	
	
	public Square(double side) {
		super(side,side);
	}
	
	@Override
	public double getArea() {
		return super.getWidth() * super.getHeight();
	}
	
	public double getSide() {
		return super.getWidth();
	}
	
	
}
