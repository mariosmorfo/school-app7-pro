package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.StudentServiceImpl;

import java.util.Optional;

public class StudentMapper {

    private StudentMapper(){}

    public static Student mapStudentInsertToModel(StudentInsertDTO dto) {
        return new Student(null, dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getFathername(),
                dto.getPhoneNum(), dto.getStreet(), dto.getStreetNum(), dto.getZipcode(), dto.getCityId(), null, null, null);
    }

    public static Student mapStudentUpdateToModel(StudentUpdateDTO dto) {
         return new Student(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getFathername(),
                dto.getPhoneNum(), dto.getStreet(), dto.getStreetNum(), dto.getZipcode(), dto.getCityId(), null, null, null);
    }

    public static Optional<StudentReadOnlyDTO> mapStudentReadOnlyDto(Student student){
        if(student == null) return Optional.empty();

        return Optional.of(new StudentReadOnlyDTO(student.getId(), student.getUuid(), student.getFirstname(),
                student.getLastname(), student.getBirthdate(), student.getFathername(), student.getPhoneNum(), student.getStreet(),
                student.getStreetNum(), student.getZipcode(), student.getCityId()));
    }

}
