package com.example.administrator.model;

/**
 * Created by zzc on 2017/10/29.
 */

public class User {

    //后台接口必填字段
    private String userAcc;
    private String nickName;
    private String pwd;
    private String phoneNumber;
    private String email;
    //后台接口非必填字段
    private String userName;
    private int male;  //性别
    //无用字段
    private int  verifyType;
    private int  userGrade;


    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }
}
