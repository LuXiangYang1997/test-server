package com.example.test.demo.evtity;

public class UserAccountBean {

    private String phoneNumber;
    private String passWord;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserAccountBean{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
