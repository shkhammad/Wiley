import java.time.LocalTime;

public class Snapdragon implements Processor{
	private int model;
	
	public Snapdragon(int model) {
		this.model = model;
	}
	
	@Override
	public String makeCall() {
		return "Calling...";
	}

	@Override
	public String sendMessage() {
		return "Message Sent";
	}

	@Override
	public String setAlarm() {
		return "Alarm set for "+ LocalTime.now().plusHours(8);
	}
	
	public int getModel() {
		return this.model;
	}
}
