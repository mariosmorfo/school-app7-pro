package gr.aueb.cf.schoolapp.dto;

public abstract class BaseDTOStudent {

    private String firstname;
    private String lastname;
    private String birthdate;
    private String fathername;
    private String phoneNum;
    private String street;
    private String streetNum;
    private String zipcode;
    private Integer cityId;

    public BaseDTOStudent(){

    }

    public BaseDTOStudent(String firstname, String lastname, String birthdate, String fathername, String phoneNum, String street, String streetNum, String zipcode, Integer cityId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.fathername = fathername;
        this.phoneNum = phoneNum;
        this.street = street;
        this.streetNum = streetNum;
        this.zipcode = zipcode;
        this.cityId = cityId;
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
}
