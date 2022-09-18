public class Email {
	private String email;
	
	public Email(String email) {
		this.email = email;
	}
	
	public String isValid() throws EmailException {
			
		String pattern = "[a-zA-Z0-9_/=?^`{|}~!#$%&'*+-]{1,}\\.{0,1}[a-zA-Z0-9__/=?^`{|}~!#$%&'*+-]{1,}@[a-z]+\\.com"; 
		
		if(!email.matches(pattern))
			throw new EmailException();
		
			
		return "Your email address is valid";
	}
	
}
