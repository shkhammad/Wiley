
public class Sony implements Camera{
	private String model;
	
	public Sony(String model) {
		this.model = model;
	}
	
	@Override
	public int resolution() {
		return 16;
	}
	
	@Override
	public String takePhoto() {
		return "Picture Captured";
	}
	
	@Override
	public String zoom() {
		return "Zoomed by 5X";
	}
	
	public String getModel() {
		return this.model;
	}
}
