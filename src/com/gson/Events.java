
package com.gson;

import java.util.List;

public class Events{
   	private String city;
   	private String country;
   	private String crDate;
   	private Number deleted;
   	private String emDate;
   	private List eventContact;
   	private List eventDate;
   	private List eventProtocol;
   	private Number iD;
   	private Number lNG;
   	private Number laT;
   	private String lang;
   	private Number locked;
   	private String name;
   	private String state;
   	private Number status;
   	private TimeZone timeZone;
   	private Number timeZoneID;
   	private User user;
   	private Number userID;
   	private Number yearly;

 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public String getCrDate(){
		return this.crDate;
	}
	public void setCrDate(String crDate){
		this.crDate = crDate;
	}
 	public Number getDeleted(){
		return this.deleted;
	}
	public void setDeleted(Number deleted){
		this.deleted = deleted;
	}
 	public String getEmDate(){
		return this.emDate;
	}
	public void setEmDate(String emDate){
		this.emDate = emDate;
	}
 	public List getEventContact(){
		return this.eventContact;
	}
	public void setEventContact(List eventContact){
		this.eventContact = eventContact;
	}
 	public List getEventDate(){
		return this.eventDate;
	}
	public void setEventDate(List eventDate){
		this.eventDate = eventDate;
	}
 	public List getEventProtocol(){
		return this.eventProtocol;
	}
	public void setEventProtocol(List eventProtocol){
		this.eventProtocol = eventProtocol;
	}
 	public Number getID(){
		return this.iD;
	}
	public void setID(Number iD){
		this.iD = iD;
	}
 	public int getLNG(){
		return this.lNG.intValue();
	}
	public void setLNG(Number lNG){
		this.lNG = lNG;
	}
 	public int getLaT(){
		return this.laT.intValue();
	}
	public void setLaT(Number laT){
		this.laT = laT;
	}
 	public String getLang(){
		return this.lang;
	}
	public void setLang(String lang){
		this.lang = lang;
	}
 	public Number getLocked(){
		return this.locked;
	}
	public void setLocked(Number locked){
		this.locked = locked;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
 	public Number getStatus(){
		return this.status;
	}
	public void setStatus(Number status){
		this.status = status;
	}
 	public TimeZone getTimeZone(){
		return this.timeZone;
	}
	public void setTimeZone(TimeZone timeZone){
		this.timeZone = timeZone;
	}
 	public Number getTimeZoneID(){
		return this.timeZoneID;
	}
	public void setTimeZoneID(Number timeZoneID){
		this.timeZoneID = timeZoneID;
	}
 	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
 	public Number getUserID(){
		return this.userID;
	}
	public void setUserID(Number userID){
		this.userID = userID;
	}
 	public Number getYearly(){
		return this.yearly;
	}
	public void setYearly(Number yearly){
		this.yearly = yearly;
	}
}
