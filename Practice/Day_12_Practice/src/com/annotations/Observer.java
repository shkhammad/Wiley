package com.annotations;

public interface Observer {
	
	void setSubject(Subject subject);
	void update();
}
