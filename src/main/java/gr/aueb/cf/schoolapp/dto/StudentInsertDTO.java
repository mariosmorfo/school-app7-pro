package gr.aueb.cf.schoolapp.dto;

public class StudentInsertDTO extends BaseDTOStudent {

    public StudentInsertDTO(){

    }

    public StudentInsertDTO(String firstname, String lastname, String birthdate, String fathername, String phoneNum,
                            String street, String streetNum, String zipcode, Integer cityId) {
        super(firstname, lastname, birthdate, fathername, phoneNum, street, streetNum, zipcode, cityId);
    }


}
