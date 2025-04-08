package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.exceptions.StudentAlreadyExistsException;
import gr.aueb.cf.schoolapp.exceptions.StudentNotFoundException;

import java.util.List;

public interface IStudentService {

    StudentReadOnlyDTO insertStudent(StudentInsertDTO dto) throws StudentDAOException, StudentAlreadyExistsException;

    StudentReadOnlyDTO updateStudent(Integer id, StudentUpdateDTO dto) throws StudentDAOException ,StudentNotFoundException;

    void deleteStudent(Integer id) throws StudentDAOException, StudentNotFoundException;

    StudentReadOnlyDTO getStudentById(Integer id) throws StudentDAOException, StudentNotFoundException;

    List<StudentReadOnlyDTO> getAllStudents() throws StudentDAOException, StudentNotFoundException;
    List<StudentReadOnlyDTO> getStudentByLastname (String lastname) throws StudentDAOException, StudentNotFoundException;

}
