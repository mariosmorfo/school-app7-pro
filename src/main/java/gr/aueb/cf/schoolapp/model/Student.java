package gr.aueb.cf.schoolapp.model;

import java.time.LocalDateTime;

public class Student {

    private Integer id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String fathername;
    private String phoneNum;
    private String street;
    private String streetNum;
    private String zipcode;
    private Integer cityId;
    private String uuid;
    private LocalDateTime updatedat;
    private LocalDateTime createdat;

    public Student() {

    }

    public Student(Integer id, String firstname, String lastname, String birthdate, String fathername, String phoneNum, String street, String streetNum, String zipcode, Integer cityId, String uuid, LocalDateTime updatedat, LocalDateTime createdat) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.fathername = fathername;
        this.phoneNum = phoneNum;
        this.street = street;
        this.streetNum = streetNum;
        this.zipcode = zipcode;
        this.cityId = cityId;
        this.uuid = uuid;
        this.updatedat = updatedat;
        this.createdat = createdat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }
}