
public enum Color {
	RED(1),GREEN(2),BLUE(3);
	
	int intensity;
	
	private Color(int intensity) {
		this.intensity = intensity;
	}
	
	public int getIntensity() {
		return this.intensity;
	}
	
}
