
package com.gson;

import java.util.List;

public class EventContact{
   	private String email;
   	private Number eventID;
   	private String fullName;
   	private Number iD;
   	private String phone;
   	private Number position;
   	private String title;

 	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
 	public Number getEventID(){
		return this.eventID;
	}
	public void setEventID(Number eventID){
		this.eventID = eventID;
	}
 	public String getFullName(){
		return this.fullName;
	}
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
 	public Number getID(){
		return this.iD;
	}
	public void setID(Number iD){
		this.iD = iD;
	}
 	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
 	public Number getPosition(){
		return this.position;
	}
	public void setPosition(Number position){
		this.position = position;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}
