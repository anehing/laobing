package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("driver")	
public class Driver implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PK		
	@TODO("id")		
    private int id;
	@TODO("job_status")		
    private int job_status;
	@TODO("stars")		
    private int stars;
	@TODO("sex")		
    private int sex;
	@TODO("age")		
    private int age;
	@TODO("cityid")		
    private int cityid;
	@TODO("mc")		
    private String mc;
	@TODO("year")		
    private int year;
	@TODO("times")		
    private int times;
	@TODO("name")	
	private String name;
	@TODO("telphone")	
	private String telphone;
	@TODO("ident_num")	
	private String ident_num;
	@TODO("picture")	
	private String picture;
	@TODO("city")	
	private String city;
	@TODO("drive_card")	
	private String drive_card;
	@TODO("servicefee")		
    private float servicefee;
	@TODO("longitude")	
	private double longitude;
	@TODO("latitude")	
	private double latitude;
	@TODO("distance")	
	private String distance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJob_status() {
		return job_status;
	}
	public void setJob_status(int job_status) {
		this.job_status = job_status;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getIdent_num() {
		return ident_num;
	}
	public void setIdent_num(String ident_num) {
		this.ident_num = ident_num;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDrive_card() {
		return drive_card;
	}
	public void setDrive_card(String drive_card) {
		this.drive_card = drive_card;
	}
	public float getServicefee() {
		return servicefee;
	}
	public void setServicefee(float servicefee) {
		this.servicefee = servicefee;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
	
}