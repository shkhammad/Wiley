package com.annotations;

public class TopicSubscriber implements Observer{
	
	private String name;
	private Subject subject;
	
	public TopicSubscriber(String name) {
		this.name = name;
	}
	
	@Override
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		
		String message = (String)subject.getUpdate(this);
		
		if(message == null)
			System.out.println("No new message");
		else
			System.out.println("Message consumed by: " + this.name + " " + message);
		
	}
	
}
