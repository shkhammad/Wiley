//example of loose-coupling (decomposition --> aggregation)

public class SmartPhone{
	Processor processor;
	Camera camera;
	
	public SmartPhone(Processor processor, Camera camera) {
		this.processor = processor;
		this.camera = camera;
	}
	
	public String makeCall() {
		return this.processor.makeCall();
	}
	
	public int resolution() {
		return this.camera.resolution();
	}
	
	public String takePhoto() {
		return this.camera.takePhoto();
	}
	
	public String zoom() {
		return this.camera.zoom();
	}
	
	public String setAlarm() {
		return this.processor.setAlarm();
	}
	
	public String sendMessage() {
		return this.processor.sendMessage();
	}
	
	public String getCameraModel() {
		return ((Sony)this.camera).getModel();
	}
	
	public int getProcessorModel() {
		return ((Snapdragon)this.processor).getModel();
	}
}
