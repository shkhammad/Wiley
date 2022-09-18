
public class Address {
	private String flatNumber, flatName,roadName,cityName; 
	
	public Address(String flatNumber, String flatName, String roadName, String cityName) {
		this.flatNumber = flatNumber;
		this.flatName = flatName;
		this.roadName = roadName;
		this.cityName = cityName;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public String getFlatName() {
		return flatName;
	}

	public String getRoadName() {
		return roadName;
	}

	public String getCityName() {
		return cityName;
	}
	
}
