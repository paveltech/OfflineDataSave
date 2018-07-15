package com.pojo;

public class DataItem {


    public String person_name;
    public String person_date;
    public String area;
    public String mailingAddress;
    public String city;
    public String mobileNumber;
    public String emailAddress;
    public String otherBrands;
    public int generInfo;
    public int smokkingBrand;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String data;

    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataItem(){

    }

    public DataItem(String person_name , String person_date , String area , String mailingAddress , String city , String mobileNumber , String emailAddress ,
                    String otherBrands  , int generInfo , int smokkingBrand){
        this.person_name = person_name;
        this.person_date = person_date;
        this.area = area;
        this.mailingAddress = mailingAddress;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.otherBrands = otherBrands;
        this.generInfo = generInfo;
        this.smokkingBrand = smokkingBrand;
    }


    public int getGenerInfo() {
        return generInfo;
    }

    public int getSmokkingBrand() {
        return smokkingBrand;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOtherBrands() {
        return otherBrands;
    }

    public String getPerson_date() {
        return person_date;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setGenerInfo(int generInfo) {
        this.generInfo = generInfo;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setOtherBrands(String otherBrands) {
        this.otherBrands = otherBrands;
    }

    public void setPerson_date(String person_date) {
        this.person_date = person_date;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public void setSmokkingBrand(int smokkingBrand) {
        this.smokkingBrand = smokkingBrand;
    }

}
