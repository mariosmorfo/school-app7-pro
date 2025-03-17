package gr.aueb.cf.schoolapp.dto;

public class StudentReadOnlyDTO extends BaseDTOStudent {

    private Integer id;
    private String uuid;

    public StudentReadOnlyDTO(){

    }

    public StudentReadOnlyDTO(Integer id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public StudentReadOnlyDTO( Integer id, String uuid, String firstname, String lastname, String birthdate, String fathername, String phoneNum, String street, String streetNum, String zipcode, Integer cityId ) {
        super(firstname, lastname, birthdate, fathername, phoneNum, street, streetNum, zipcode, cityId);
        this.id = id;
        this.uuid = uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
