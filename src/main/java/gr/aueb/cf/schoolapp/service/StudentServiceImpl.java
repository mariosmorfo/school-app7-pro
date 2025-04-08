package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.exceptions.StudentAlreadyExistsException;
import gr.aueb.cf.schoolapp.exceptions.StudentNotFoundException;
import gr.aueb.cf.schoolapp.exceptions.TeacherNotFoundException;
import gr.aueb.cf.schoolapp.mapper.Mapper;
import gr.aueb.cf.schoolapp.mapper.StudentMapper;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {

    private final IStudentDAO studentDAO;

    public StudentServiceImpl(IStudentDAO iStudentDAO) {
        this.studentDAO = iStudentDAO;
    }

    @Override
    public StudentReadOnlyDTO insertStudent(StudentInsertDTO dto) throws StudentDAOException, StudentAlreadyExistsException {
        Student student;
        Student insertedStudent;

        try {
            student = StudentMapper.mapStudentInsertToModel(dto);
            if(studentDAO.getByLastname(dto.getLastname()) == null)
                throw new StudentAlreadyExistsException("Student with this lastname " + dto.getLastname() + " already exists");
            insertedStudent = studentDAO.insert(student);
            return StudentMapper.mapStudentReadOnlyDto(insertedStudent).orElse(null);

        }catch (StudentDAOException e) {

            throw e;
        }catch (StudentAlreadyExistsException e) {
            throw e;
        }
    }

    @Override
    public StudentReadOnlyDTO updateStudent(Integer id, StudentUpdateDTO dto) throws StudentDAOException, StudentNotFoundException {
        Student student;
        Student fetchedStudent;

        try{
            if(studentDAO.getById(id) == null)
                throw new StudentNotFoundException("Student with id: " + id + " not exists");

            fetchedStudent = studentDAO.getById(dto.getId());
            if(fetchedStudent != null && !fetchedStudent.getId().equals(dto.getId())){
                throw new StudentAlreadyExistsException("Student with lastname: " + dto.getLastname() + " already exists");
            }
            student = StudentMapper.mapStudentUpdateToModel(dto);
            Student updatedStudent = studentDAO.update(student);

            return StudentMapper.mapStudentReadOnlyDto(updatedStudent).orElse(null);

        }catch (StudentDAOException | StudentNotFoundException e){
            throw e;
        }
    }

    @Override
    public void deleteStudent(Integer id) throws StudentDAOException, StudentNotFoundException {
        try {
            if (studentDAO.getById(id) == null) {
                throw new StudentNotFoundException("Student not found ");
            }
            studentDAO.delete(id);
        } catch (StudentDAOException | StudentNotFoundException e) {
            // e.printStackTrace();
            // rollback
            throw e;
        }
    }

    @Override
    public StudentReadOnlyDTO getStudentById(Integer id) throws StudentDAOException, StudentNotFoundException {
        Student student;

        try {
            student = studentDAO.getById(id);
            return StudentMapper.mapStudentReadOnlyDto(student).orElseThrow(() -> new StudentNotFoundException("Student not found in get teacher by id"));
        } catch (StudentDAOException | StudentNotFoundException e) {
            //e.printStackTrace();
            // rollback
            throw e;
        }
    }

    @Override
    public List<StudentReadOnlyDTO> getAllStudents() throws StudentDAOException, StudentNotFoundException {
        List<Student> students;

        try {
            students = studentDAO.getAll();
            return students.stream()
                    .map(StudentMapper::mapStudentReadOnlyDto)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (StudentDAOException | StudentNotFoundException e) {
            // e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentReadOnlyDTO> getStudentByLastname(String lastname) throws StudentDAOException, StudentNotFoundException {

        List<Student> students;

        try {
            students = studentDAO.getByLastname(lastname);
            return students.stream()
                    .map(StudentMapper::mapStudentReadOnlyDto)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (StudentDAOException | StudentNotFoundException e) {
            // e.printStackTrace();
            throw e;
        }
}
}
