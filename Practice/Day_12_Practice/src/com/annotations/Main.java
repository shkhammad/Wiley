package com.annotations;

@Simple(place = "Mumbai")
public class Main {
	public static void main(String[] args) {
		
		//only one instance of the Singleton class exists in the JVM at a time
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		
		if(singleton == singleton2)
			System.out.println("Yes");
	
		
		//Factory Design Pattern
		//Factory design pattern provides approach to code for interface 
		//rather than implementation
		//Factory pattern removes the instantiation of actual implementation 
		//classes from client code
		Computer samsung = ComputerFactory.getComputer("Samsung", "Snapdragon", 16, 128);
		System.out.println(samsung);
		
		Computer apple = ComputerFactory.getComputer("Apple", "Bionic", 32, 64);
		System.out.println(apple);
		
		
		//observer design pattern
		//loose-coupling between objects
		//here both the subject and observer are both loosely-coupled
		//they do not depend on each other
		//TopicPublisher depends on Observer interface (which is implemented by TopicSubsrciber)
		//TopicSubscriber depends on Subject interface (which is implemented by TopicPublisher)
		//hence type of observers can change without the changing the TopicPublisher's code
		TopicPublisher tp = new TopicPublisher();
		
		Observer o1 = new TopicSubscriber("Hammad");
		Observer o2 = new TopicSubscriber("Sikandar");
		Observer o3 = new TopicSubscriber("Samina");
		
		o1.setSubject(tp);
		o2.setSubject(tp);
		o3.setSubject(tp);
		
		tp.register(o1);
		tp.register(o2);
		tp.register(o3);
		
		o1.update();
		tp.postMessage("This is a message");
		
		tp.notifyObservers();
	}
}
