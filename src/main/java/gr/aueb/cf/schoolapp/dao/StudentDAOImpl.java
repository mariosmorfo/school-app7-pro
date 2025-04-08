package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.util.DBUtil;
import jdk.jfr.StackTrace;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public Student insert(Student student) throws StudentDAOException {
        String sql = "INSERT INTO students (firstname, lastname, birthdate, fathername, phone_num, street, street_num, zipcode, city_id, uuid, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Student insertedStudent = null;

        try (Connection connection = DBUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Parse birthdate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthdate = LocalDate.parse(student.getBirthdate(), formatter);

            // Generate UUID and Timestamp once
            String uuid = UUID.randomUUID().toString();
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());

            // Set parameters
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setDate(3, Date.valueOf(birthdate));
            ps.setString(4, student.getFathername());
            ps.setString(5, student.getPhoneNum());
            ps.setString(6, student.getStreet());
            ps.setString(7, student.getStreetNum());
            ps.setString(8, student.getZipcode());
            ps.setInt(9, student.getCityId());
            ps.setString(10, uuid);
            ps.setTimestamp(11, now);
            ps.setTimestamp(12, now);

            ps.executeUpdate();


            ResultSet rsGeneratedKeys = ps.getGeneratedKeys();
            if (rsGeneratedKeys.next()) {
                int generateId = rsGeneratedKeys.getInt(1);
                insertedStudent = getById(generateId);
            }

            return insertedStudent;

        } catch (SQLException e) {
            throw new StudentDAOException("SQL error in insert student: " + e.getMessage());
        }
    }


    @Override
    public Student update(Student student) throws StudentDAOException {
        String sql = "UPDATE  students SET firstname = ? , lastname = ? , birthdate = ?, fathername = ?, phone_num = ?, street = ?, street_num = ?, zipcode = ?,  city_id = ?, uuid = ?, updated_at = ? " +
                "WHERE id = ?";

        Student updatedStudent = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql))
        {
            // Parse birthdate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthdate = LocalDate.parse(student.getBirthdate(), formatter);

            // Generate UUID and Timestamp once
            String uuid = UUID.randomUUID().toString();
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());

            // Set parameters
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setDate(3, Date.valueOf(birthdate));
            ps.setString(4, student.getFathername());
            ps.setString(5, student.getPhoneNum());
            ps.setString(6, student.getStreet());
            ps.setString(7, student.getStreetNum());
            ps.setString(8, student.getZipcode());
            ps.setInt(9, student.getCityId());
            ps.setString(10, uuid);
            ps.setTimestamp(11, now);
            ps.setTimestamp(12, now);
            ps.setInt(13, student.getId());
            ps.executeQuery();


            updatedStudent = getById(student.getId());
            return updatedStudent;

        }catch (SQLException e){
            e.printStackTrace();
            throw new StudentDAOException("SQL error in update student.");
        }
    }

    @Override
    public void delete(Integer id) throws StudentDAOException {

        String sql = "DELETE FROM students WHERE id = ?";

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeQuery();

        }catch (SQLException e){
            throw new StudentDAOException("SQL error in delete student with id:" + id);
        }

    }

    @Override
    public Student getById(Integer id) throws StudentDAOException {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        ResultSet rs;

        try(Connection connection = DBUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("birthdate"),rs.getString("fathername"), rs.getString("phone_num"), rs.getString("street"), rs.getString("street_num"),
                        rs.getString("zipcode"), rs.getInt("city_id"), rs.getString("uuid"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());


            }

            return student;
        }catch (SQLException e){
            throw new StudentDAOException("SQL error in get by id with id: " + id);
        }
    }

    @Override
    public List<Student> getAll() throws StudentDAOException {
        String sql = "SELECT * FROM students";
        Student student;
        List<Student> students = new ArrayList<>();
        ResultSet rs;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){


            rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("birthdate"),rs.getString("fathername"), rs.getString("phone_num"), rs.getString("street"), rs.getString("street_num"),
                        rs.getString("zipcode"), rs.getInt("city_id"), rs.getString("uuid"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());

                students.add(student);
            }

            return students;


        }catch (SQLException e){
            throw new StudentDAOException("SQL error in get all");
        }
    }

    @Override
    public List<Student> getByLastname(String lastname) throws StudentDAOException {
        String sql = "SELECT * FROM students WHERE lastname like ?";
        Student student;
        List<Student> students = new ArrayList<>();
        ResultSet rs;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, lastname + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("birthdate"),rs.getString("fathername"), rs.getString("phone_num"), rs.getString("street"), rs.getString("street_num"),
                        rs.getString("zipcode"), rs.getInt("city_id"), rs.getString("uuid"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());

                students.add(student);
            }

            return students;


        }catch (SQLException e){
            throw new StudentDAOException("SQL error in get student with lastname: " + lastname);
        }
    }
}
