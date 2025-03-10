package gr.aueb.cf.schoolapp.dto;

public class TeacherInsertDTO extends BaseDTO{

    public TeacherInsertDTO(){

    }

    public TeacherInsertDTO(String firstname, String lastname, String vat, String fatherName, String phoneNum,
                            String email, String street, String streetNum, String zipcode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNum, email, street, streetNum, zipcode, cityId);
    }
}
