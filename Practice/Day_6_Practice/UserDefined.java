
public class UserDefined extends Exception{

	private static final long serialVersionUID = 1L;
	String message;
	
	public UserDefined() {
		message = "user_defined";
	}
	
	//if we override toString method in the child class it will 
	//execute the contents of that method
	//else it will be by default 
	//<Name of the Exception_Class> <:> <getMessage method>
	
	@Override
	public String toString() {
		return "In UserDefined Exception";
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
