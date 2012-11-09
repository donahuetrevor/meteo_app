
package com.gson;

import java.util.List;

public class EventProtocol{
   	private String comment;
   	private Number eventID;
   	private Number iD;
   	private String operator;
   	private Number position;
   	private String type;
   	private String unit;
   	private String value;

 	public String getComment(){
		return this.comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
 	public Number getEventID(){
		return this.eventID;
	}
	public void setEventID(Number eventID){
		this.eventID = eventID;
	}
 	public Number getID(){
		return this.iD;
	}
	public void setID(Number iD){
		this.iD = iD;
	}
 	public String getOperator(){
		return this.operator;
	}
	public void setOperator(String operator){
		this.operator = operator;
	}
 	public Number getPosition(){
		return this.position;
	}
	public void setPosition(Number position){
		this.position = position;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public String getUnit(){
		return this.unit;
	}
	public void setUnit(String unit){
		this.unit = unit;
	}
 	public String getValue(){
		return this.value;
	}
	public void setValue(String value){
		this.value = value;
	}
}
