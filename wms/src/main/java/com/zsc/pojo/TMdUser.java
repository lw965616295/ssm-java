package com.zsc.pojo;

import java.util.Arrays;
import java.util.Date;

public class TMdUser {
    private Integer userId;

    private String createBy;

    private Date createTime;

    private Integer del;

    private String email;

    private String loginTime;

    private String modiBy;

    private Date modiTime;

    private String passWord;

    private String phone;

    private String theOwner;

    private String userName;

    private String whCode;

    private String userPicUrl;

    private byte[] icon;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime == null ? null : loginTime.trim();
    }

    public String getModiBy() {
        return modiBy;
    }

    public void setModiBy(String modiBy) {
        this.modiBy = modiBy == null ? null : modiBy.trim();
    }

    public Date getModiTime() {
        return modiTime;
    }

    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTheOwner() {
        return theOwner;
    }

    public void setTheOwner(String theOwner) {
        this.theOwner = theOwner == null ? null : theOwner.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl == null ? null : userPicUrl.trim();
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

	@Override
	public String toString() {
		return "TMdUser [userId=" + userId + ", createBy=" + createBy + ", createTime=" + createTime + ", del=" + del
				+ ", email=" + email + ", loginTime=" + loginTime + ", modiBy=" + modiBy + ", modiTime=" + modiTime
				+ ", passWord=" + passWord + ", phone=" + phone + ", theOwner=" + theOwner + ", userName=" + userName
				+ ", whCode=" + whCode + ", userPicUrl=" + userPicUrl + ", icon=" + Arrays.toString(icon) + "]";
	}
    
}