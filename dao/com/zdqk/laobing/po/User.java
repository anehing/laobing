package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("users")	
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private Long id;
	
	@TODO("username")	
	private String userName;	
	@TODO("parentid")
	private Long parentId;
	@TODO("parentName")
	private String parentName;	
	@TODO("name")
	private String name;	
	@TODO("pass")	
    private String pass;
	@TODO("photourl")
	private String photoUrl;
	@TODO("sex")
	private Long sex;
	@TODO("age")
	private Long age;
	@TODO("usertype")
	private Long userType;
	@TODO("mobile") 
    private String mobile;
	@TODO("mobilechecked") 
    private Long mobileChecked;	
	@TODO("email")
    private String email;
	@TODO("emailchecked")
    private Long emailChecked;	
	@TODO("regdate")
    private Date regDate;
	@TODO("regdatetime")
    private Date regDateTime;
	@TODO("province")
	private Long province;	
	@TODO("city")
	private Long city;	
	@TODO("country")
	private Long country;	
	@TODO("address") 
    private String address;		
	@TODO("checkstatus")
    private Long checkStatus;
	@TODO("status")
    private Long status;
	@TODO("note")
    private String note;
	@TODO("birthday")
	private Date birthday;
	@TODO("nickname")	
	private String nickName;
	@TODO("sinatoken")
	private String sinaToken;
	private String userIdStr;
	private String regDateStr;
	private String birthdayStr;
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRegDateStr() {
		return regDateStr;
	}
	public void setRegDateStr(String regDateStr) {
		this.regDateStr = regDateStr;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSinaToken() {
		return sinaToken;
	}
	public void setSinaToken(String sinaToken) {
		this.sinaToken = sinaToken;
	}
	public User() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getUserType() {
		return userType;
	}
	public void setUserType(Long userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Long checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Long getSex() {
		return sex;
	}
	public void setSex(Long sex) {
		this.sex = sex;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public Long getMobileChecked() {
		return mobileChecked;
	}
	public void setMobileChecked(Long mobileChecked) {
		this.mobileChecked = mobileChecked;
	}
	public Long getEmailChecked() {
		return emailChecked;
	}
	public void setEmailChecked(Long emailChecked) {
		this.emailChecked = emailChecked;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Long getProvince() {
		return province;
	}
	public void setProvince(Long province) {
		this.province = province;
	}
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public Long getCountry() {
		return country;
	}
	public void setCountry(Long country) {
		this.country = country;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getUserIdStr() {
		return userIdStr;
	}
	public void setUserIdStr(String userIdStr) {
		this.userIdStr = userIdStr;
	}
}