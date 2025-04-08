package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.dao.*;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.schoolapp.exceptions.StudentNotFoundException;
import gr.aueb.cf.schoolapp.exceptions.TeacherAlreadyExistsException;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.service.*;

//import gr.aueb.cf.schoolapp.model.City;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertStudentPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstnameText;
    private JTextField lastnameText;
    private JTextField birthdateText;
    private JTextField fathernameText;
    private JTextField phoneNumberText;
    private JTextField streetText;
    private JTextField streetNumberText;
    private JTextField zipcodeText;
    private JLabel errorFirstname;
    private JLabel errorLastname;
    private JLabel errorBirthdate;
    private JLabel errorfathername;
    private JLabel errorPhoneNumber;
    private JLabel errorStreet;
    private JLabel errorStreetNumber;
    private JLabel errorZipCode;
    private JComboBox<City> cityComboBox;
    private List<City> cities = new ArrayList<>();

    private final ICityDAO cityDao = new CityDAOImpl();
    private final ICityService cityService = new CityServiceImpl(cityDao);

    private final IStudentDAO studentDAO = new StudentDAOImpl();
    private final IStudentService studentService = new StudentServiceImpl(studentDAO);

    public InsertStudentPage() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                try {
                    cityService.getAllCities().forEach(cityComboBox::addItem);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Get cities fatal error. " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Ποιότητα στην Εκπαίδευση");
        setBounds(100, 100, 857, 701);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTeacherInfo = new JLabel("Στοιχεία Μαθητή");
        lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTeacherInfo.setBounds(324, 63, 341, 44);
        contentPane.add(lblTeacherInfo);

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(0, 52, 117));
        header.setBounds(0, 0, 842, 52);
        contentPane.add(header);

        JLabel govImage = new JLabel("");
        govImage.setIcon(new ImageIcon(InsertTeacherPage.class.getResource("/images/gov_logo_small.png")));
        govImage.setBounds(0, 0, 100, 52);
        header.add(govImage);

        JLabel firstLastName = new JLabel("ΜΟΡΦΟΝΙΔΗΣ ΜΑΡΙΟΣ");
        firstLastName.setForeground(Color.WHITE);
        firstLastName.setBounds(649, 11, 183, 30);
        header.add(firstLastName);

        JPanel footer = new JPanel();
        footer.setLayout(null);
        footer.setBounds(0, 574, 842, 90);
        contentPane.add(footer);

        JLabel lbl_manual = new JLabel("Εγχειρίδιο Χρήσης");
        lbl_manual.setForeground(new Color(0, 52, 117));
        lbl_manual.setBounds(199, 37, 151, 29);
        footer.add(lbl_manual);

        JLabel lbl_oftenQuestions = new JLabel("Συχνές Ερωτήσεις");
        lbl_oftenQuestions.setForeground(new Color(0, 52, 117));
        lbl_oftenQuestions.setBounds(360, 37, 151, 29);
        footer.add(lbl_oftenQuestions);

        JLabel lbl_support = new JLabel("Υποστήριξη Πολιτών");
        lbl_support.setForeground(new Color(0, 52, 117));
        lbl_support.setBounds(521, 37, 151, 29);
        footer.add(lbl_support);

        JSeparator lineBottom = new JSeparator();
        lineBottom.setBackground(Color.BLUE);
        lineBottom.setBounds(0, 0, 850, 2);
        footer.add(lineBottom);

        firstnameText = new JTextField();
        firstnameText.setBounds(91, 131, 263, 37);
        contentPane.add(firstnameText);
        firstnameText.setColumns(10);

        firstnameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String inputFirstname;
                inputFirstname = firstnameText.getText().trim();

                errorFirstname.setText(inputFirstname.equals("") ? "Το όνομα είναι υποχρεωτικό" : "");
            }
        });

        lastnameText = new JTextField();
        lastnameText.setColumns(10);
        lastnameText.setBounds(512, 131, 263, 37);
        contentPane.add(lastnameText);

        lastnameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String inputLastname;
                inputLastname = lastnameText.getText().trim();

                errorLastname.setText(inputLastname.equals("") ? "Το επώνυμο είναι υποχρεωτικό" : "");
            }
        });

        JLabel lblFirstname = new JLabel("Όνομα*");
        lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblFirstname.setBounds(29, 135, 62, 29);
        contentPane.add(lblFirstname);

        JLabel lblLastname = new JLabel("Επώνυμο*");
        lblLastname.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLastname.setBounds(432, 135, 84, 29);
        contentPane.add(lblLastname);

        JLabel lblBirthdate = new JLabel("Birthdate*");
        lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblBirthdate.setBounds(21, 201, 70, 29);
        contentPane.add(lblBirthdate);

        birthdateText = new JTextField();
        birthdateText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String inputvat;
                inputvat = birthdateText.getText().trim();

                errorBirthdate.setText(inputvat.equals("") ? "Η ημερομηνία γέννησης είναι υποχρεωτική" : "");

            }
        });
        birthdateText.setColumns(10);
        birthdateText.setBounds(91, 198, 263, 37);
        contentPane.add(birthdateText);

        JLabel lblFathername = new JLabel("Πατρώνυμο*");
        lblFathername.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblFathername.setBounds(421, 202, 95, 29);
        contentPane.add(lblFathername);

        fathernameText = new JTextField();
        fathernameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String inputfathername;

                inputfathername = fathernameText.getText().trim();

                errorfathername.setText(inputfathername.equals("") ? "Το πατρώνυμο είναι υποχρεωτικό" : "");
            }
        });
        fathernameText.setColumns(10);
        fathernameText.setBounds(512, 198, 263, 37);
        contentPane.add(fathernameText);

        JLabel lblPhoneNumber = new JLabel("Τηλέφωνο*");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPhoneNumber.setBounds(10, 275, 81, 29);
        contentPane.add(lblPhoneNumber);

        phoneNumberText = new JTextField();
        phoneNumberText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String inputPhoneNumber;

                inputPhoneNumber = phoneNumberText.getText().trim();

                errorPhoneNumber.setText(inputPhoneNumber.equals("") ? "Το τηλέφωνο είναι υποχρεωτικό" : "");
            }
        });
        phoneNumberText.setColumns(10);
        phoneNumberText.setBounds(91, 271, 263, 37);
        contentPane.add(phoneNumberText);

        JLabel lblStreet = new JLabel("Διεύθυνση*");
        lblStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStreet.setBounds(10, 342, 81, 29);
        contentPane.add(lblStreet);

        streetText = new JTextField();
        streetText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String inputStreet;

                inputStreet = streetText.getText().trim();

                errorStreet.setText(inputStreet.equals("") ? "Η διεύθυνση είναι υποχρεωτική" : "");
            }
        });
        streetText.setColumns(10);
        streetText.setBounds(91, 338, 263, 37);
        contentPane.add(streetText);

        JLabel lblStreetNumber = new JLabel("Αριθμός*");
        lblStreetNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStreetNumber.setBounds(446, 269, 70, 29);
        contentPane.add(lblStreetNumber);

        streetNumberText = new JTextField();
        streetNumberText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String inputStreetNumber;

                inputStreetNumber = streetNumberText.getText().trim();

                errorStreetNumber.setText(inputStreetNumber.equals("") ? "Ο αριθμός διεύθυνσης είναι υποχρεωτικός" : "");
            }
        });
        streetNumberText.setColumns(10);
        streetNumberText.setBounds(512, 265, 263, 37);
        contentPane.add(streetNumberText);

        JLabel lblCity = new JLabel("Πόλη*");
        lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCity.setBounds(41, 411, 50, 29);
        contentPane.add(lblCity);

        JLabel lblZipCode = new JLabel("ΤΚ*");
        lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblZipCode.setBounds(481, 338, 35, 29);
        contentPane.add(lblZipCode);

        zipcodeText = new JTextField();
        zipcodeText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                String inputZipCode;

                inputZipCode = zipcodeText.getText().trim();

                errorZipCode.setText(inputZipCode.equals("") ? "Ο ΤΚ είναι υποχρεωτικός" : "");


            }
        });
        zipcodeText.setColumns(10);
        zipcodeText.setBounds(512, 334, 263, 37);
        contentPane.add(zipcodeText);

        errorFirstname = new JLabel("");
        errorFirstname.setForeground(new Color(255, 0, 0));
        errorFirstname.setBounds(92, 167, 260, 29);
        contentPane.add(errorFirstname);

        errorLastname = new JLabel("");
        errorLastname.setForeground(new Color(255, 0, 0));
        errorLastname.setBounds(514, 167, 260, 29);
        contentPane.add(errorLastname);


        errorBirthdate = new JLabel("");
        errorBirthdate.setForeground(Color.RED);
        errorBirthdate.setBounds(92, 231, 260, 29);
        contentPane.add(errorBirthdate);

        errorfathername = new JLabel("");
        errorfathername.setForeground(Color.RED);
        errorfathername.setBounds(515, 231, 260, 29);
        contentPane.add(errorfathername);

        errorPhoneNumber = new JLabel("");
        errorPhoneNumber.setForeground(Color.RED);
        errorPhoneNumber.setBounds(94, 305, 260, 29);
        contentPane.add(errorPhoneNumber);

        errorStreet = new JLabel("");
        errorStreet.setForeground(Color.RED);
        errorStreet.setBounds(94, 377, 260, 29);
        contentPane.add(errorStreet);

        errorStreetNumber = new JLabel("");
        errorStreetNumber.setForeground(Color.RED);
        errorStreetNumber.setBounds(515, 377, 260, 29);
        contentPane.add(errorStreetNumber);


        errorZipCode = new JLabel("");
        errorZipCode.setForeground(Color.RED);
        errorZipCode.setBounds(515, 377, 260, 29);
        contentPane.add(errorZipCode);

        cityComboBox = new JComboBox<>();
        cityComboBox.setBounds(89, 407, 263, 37);
        contentPane.add(cityComboBox);


        JButton insertBtn = new JButton("Υποβολή");
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentReadOnlyDTO studentReadOnlyDTO;
               StudentInsertDTO studentInsertDTO = doDataBinding();

                // Data Binding
                studentInsertDTO = doDataBinding();

                // Validation

                try {
                    studentReadOnlyDTO = studentService.insertStudent(studentInsertDTO);
                    JOptionPane.showMessageDialog(null, "Student with lastname : " +studentReadOnlyDTO.getLastname(), "Inserted", JOptionPane.INFORMATION_MESSAGE);
                    resetInputForm();
                    // todo form instead of message dialog
                } catch (StudentDAOException | StudentNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error. " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        insertBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        insertBtn.setForeground(new Color(255, 255, 255));
        insertBtn.setBackground(new Color(64, 128, 128));
        insertBtn.setBounds(512, 485, 263, 54);
        contentPane.add(insertBtn);

        JButton closeBtn = new JButton("Κλείσιμο");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getDashboard().setEnabled(true);
                Main.getInsertStudentPage().setVisible(false);
            }
        });

        closeBtn.setForeground(new Color(0, 0, 0));
        closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        closeBtn.setBackground(new Color(192, 192, 192));
        closeBtn.setBounds(91, 485, 263, 54);
        contentPane.add(closeBtn);
    }

    private List<City> fetchCitiesFromDatabase() {
//		String sql = "SELECT * FROM cities order by name asc";
//		List<City> cities = new ArrayList();
//
//		//Connection connection = Dashboard.getConnection();
//
//		try (Connection connection = DBUtil.getConnection();
//			 PreparedStatement ps = connection.prepareStatement(sql)) {
//
//
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//
//				City city = new City(id, name);
//				cities.add(city);
//			}
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null,  "Select cities error", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		return cities;
        return null;
    }

    private StudentInsertDTO doDataBinding() {
        final int DEFAULT_CITY_ID = 1;
        String firstname = firstnameText.getText().trim();
        String lastname = lastnameText.getText().trim();
        String fathername = fathernameText.getText().trim();
        String birthdate = birthdateText.getText().trim();
        String phoneNumber = phoneNumberText.getText().trim();
        String street = streetText.getText().trim();
        String streetNumber = streetNumberText.getText().trim();
        City selectedCity = (City) cityComboBox.getSelectedItem();
        int cityId = (selectedCity != null) ? selectedCity.getId() : DEFAULT_CITY_ID;
        String zipcode = zipcodeText.getText().trim();

        return new StudentInsertDTO(firstname, lastname, birthdate, fathername, phoneNumber, street, streetNumber, zipcode, cityId);
    }

    private void resetInputForm(){
        firstnameText.setText("");
        lastnameText.setText("");
        fathernameText.setText("");
        streetText.setText("");
        streetNumberText.setText("");
        birthdateText.setText(" ");
        zipcodeText.setText("");
        cityComboBox.setSelectedIndex(0);
        errorFirstname.setText("");
        errorLastname.setText("");
        errorfathername.setText("");
        errorStreet.setText("");
        errorStreetNumber.setText("");
        errorZipCode.setText("");
        errorBirthdate.setText("");


    }

       }