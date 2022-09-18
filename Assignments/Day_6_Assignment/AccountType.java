
public enum AccountType {
	SAVINGS(4), CURRENT(2);
	
	private double rateOfInterest;
	
	private AccountType(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	public double getRateOfInterest() {
		return this.rateOfInterest;
	}
	
}
