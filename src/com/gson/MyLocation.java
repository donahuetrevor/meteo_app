
package com.gson;

import java.util.List;

public class MyLocation{
   	private List events;
   	private boolean success;

 	public List getEvents(){
		return this.events;
	}
	public void setEvents(List events){
		this.events = events;
	}
 	public boolean getSuccess(){
		return this.success;
	}
	public void setSuccess(boolean success){
		this.success = success;
	}
}
