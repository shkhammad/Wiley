package com.annotations;

import java.util.ArrayList;
import java.util.List;

public class TopicPublisher implements Subject{
	
	private List<Observer> observers;
	private boolean flag;
	private String message;
	//private Object lock = new Object();
	
	
	public TopicPublisher(){
		observers = new ArrayList<>();
	}
	
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException();
		
		synchronized (this) {
			observers.add(obj);	
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (this) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		
		List<Observer> observersLocal = null;
		
		synchronized (this) {
			
			if(!flag) return;
			
			observersLocal = new ArrayList<>(this.observers);
			flag = false;
			
		}
		
		for(Observer obj: observersLocal)
			obj.update();
		
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	public void postMessage(String message) {
		System.out.println("Message posted is: " + message);
		this.message = message;
		this.flag = true;
		notifyObservers();
	}
	
	
}
