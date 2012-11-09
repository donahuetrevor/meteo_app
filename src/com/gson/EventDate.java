
package com.gson;

import java.util.List;

public class EventDate{
   	private Number eventID;
   	private String fromDate;
   	private String toDate;

 	public Number getEventID(){
		return this.eventID;
	}
	public void setEventID(Number eventID){
		this.eventID = eventID;
	}
 	public String getFromDate(){
		return this.fromDate;
	}
	public void setFromDate(String fromDate){
		this.fromDate = fromDate;
	}
 	public String getToDate(){
		return this.toDate;
	}
	public void setToDate(String toDate){
		this.toDate = toDate;
	}
}
