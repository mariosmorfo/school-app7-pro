package gr.aueb.cf.schoolapp.dto;

public class StudentUpdateDTO extends BaseDTOStudent {

    private Integer id;

    public StudentUpdateDTO(){

    }

    public StudentUpdateDTO(Integer id) {
        this.id = id;
    }

    public StudentUpdateDTO(String firstname, String lastname, String birthdate, String fathername, String phoneNum, String street, String streetNum, String zipcode, Integer cityId, Integer id) {
        super(firstname, lastname, birthdate, fathername, phoneNum, street, streetNum, zipcode, cityId);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
