package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.model.City;

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
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertTeacherPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnameText;
	private JTextField lastnameText;
	private JTextField vatText;
	private JTextField fathernameText;
	private JTextField phoneNumberText;
	private JTextField emailText;
	private JTextField streetText;
	private JTextField streetNumberText;
	private JTextField zipcodeText;
	private JLabel errorFirstname;
	private JLabel errorLastname;
	private JLabel errorVat;
	private JLabel errorfathername;
	private JLabel errorPhoneNumber;
	private JLabel errorEmail;
	private JLabel errorStreet;
	private JLabel errorStreetNumber;
	private JLabel errorZipCode;
	private JComboBox<City> cityComboBox;
	private List<City> cities = new ArrayList<>();
	
	public InsertTeacherPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cities = fetchCitiesFromDatabase();
				cities.forEach(city -> cityComboBox.addItem(city));
				
				firstnameText.setText("");
				lastnameText.setText("");
				vatText.setText("");
				fathernameText.setText("");
				phoneNumberText.setText("");
				emailText.setText("");
				streetText.setText("");
				streetNumberText.setText("");
				cityComboBox.setSelectedIndex(0);
				zipcodeText.setText("");
				errorFirstname.setText("");
				errorLastname.setText("");
				errorVat.setText("");
				errorfathername.setText("");
				errorPhoneNumber.setText("");
				errorEmail.setText("");
				errorStreet.setText("");
				errorStreetNumber.setText("");
				errorZipCode.setText("");
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Ποιότητα στην Εκπαίδευση");
		setBounds(100, 100, 857, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherInfo = new JLabel("Στοιχεία Εκπαιδευτή");
		lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTeacherInfo.setBounds(267, 63, 341, 44);
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
		
		JLabel firstLastName = new JLabel("ΑΘΑΝΑΣΙΟΣ ΑΝΔΡΟΥΤΣΟΣ");
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
		
		JLabel lblVat = new JLabel("ΑΦΜ*");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVat.setBounds(41, 202, 50, 29);
		contentPane.add(lblVat);
		
		vatText = new JTextField();
		vatText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
				String inputvat;
				inputvat = vatText.getText().trim();
				
				errorVat.setText(inputvat.equals("") ? "Το ΑΦΜ είναι υποχρεωτικό" : "");
			
			}
		});
		vatText.setColumns(10);
		vatText.setBounds(91, 198, 263, 37);
		contentPane.add(vatText);
		
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
		
		JLabel lblEmail = new JLabel("e-mail*");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(460, 275, 56, 29);
		contentPane.add(lblEmail);
		
		emailText = new JTextField();
		emailText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String inputEmail;
				
				inputEmail = emailText.getText().trim();
				
				errorEmail.setText(inputEmail.equals("") ? "Το email είναι υποχρεωτικό" : "");
				
				
			}
		});
		emailText.setColumns(10);
		emailText.setBounds(512, 271, 263, 37);
		contentPane.add(emailText);
		
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
		lblStreetNumber.setBounds(446, 342, 70, 29);
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
		streetNumberText.setBounds(512, 338, 263, 37);
		contentPane.add(streetNumberText);
		
		JLabel lblCity = new JLabel("Πόλη*");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(41, 411, 50, 29);
		contentPane.add(lblCity);
		
		JLabel lblZipCode = new JLabel("ΤΚ*");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZipCode.setBounds(481, 411, 35, 29);
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
		zipcodeText.setBounds(512, 407, 263, 37);
		contentPane.add(zipcodeText);
		
		errorFirstname = new JLabel("");
		errorFirstname.setForeground(new Color(255, 0, 0));
		errorFirstname.setBounds(92, 167, 260, 29);
		contentPane.add(errorFirstname);
		
		errorLastname = new JLabel("");
		errorLastname.setForeground(new Color(255, 0, 0));
		errorLastname.setBounds(514, 167, 260, 29);
		contentPane.add(errorLastname);
		

		errorVat = new JLabel("");
		errorVat.setForeground(Color.RED);
		errorVat.setBounds(92, 231, 260, 29);
		contentPane.add(errorVat);
		
		errorfathername = new JLabel("");
		errorfathername.setForeground(Color.RED);
		errorfathername.setBounds(515, 231, 260, 29);
		contentPane.add(errorfathername);
		
		errorPhoneNumber = new JLabel("");
		errorPhoneNumber.setForeground(Color.RED);
		errorPhoneNumber.setBounds(94, 305, 260, 29);
		contentPane.add(errorPhoneNumber);
		

		errorEmail = new JLabel("");
		errorEmail.setForeground(Color.RED);
		errorEmail.setBounds(515, 305, 260, 29);
		contentPane.add(errorEmail);
		
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
		errorZipCode.setBounds(515, 445, 260, 29);
		contentPane.add(errorZipCode);
		
		cityComboBox = new JComboBox<>();
		cityComboBox.setBounds(89, 407, 263, 37);
		contentPane.add(cityComboBox);
        
		
		JButton insertBtn = new JButton("Υποβολή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Data Binding
			
				String firstname = firstnameText.getText().trim();
				String lastname = lastnameText.getText().trim();
				String vat = vatText.getText().trim();
				String fathername = fathernameText.getText().trim();
				String phoneNumber = phoneNumberText.getText().trim();
				String email = emailText.getText().trim();
				String street = streetText.getText().trim();
				String streetNumber = streetNumberText.getText().trim();
				City selectedCity = (City) cityComboBox.getSelectedItem();
				int cityId = selectedCity.getId();
				String zipcode = zipcodeText.getText().trim();
				
				
				// Validation
				
				errorFirstname.setText(firstname.equals("") ? "Το όνομα είναι υποχρεωτικό" : "");

				// Validate last name
				errorLastname.setText(lastname.equals("") ? "Το επώνυμο είναι υποχρεωτικό" : "");
				
				errorVat.setText(vat.equals("") ? "Το ΑΦΜ είναι υποχρεωτικό" : "");
				
				errorfathername.setText(fathername.equals("") ? "Το πατρώνυμο είναι υποχρεωτικό" : "");
				
				errorPhoneNumber.setText(phoneNumber.equals("") ? "Το τηλέφωνο είναι υποχρεωτικό" : "");
				
				errorEmail.setText(email.equals("") ? "Το email είναι υποχρεωτικό" : "");
				
				errorStreet.setText(street.equals("") ? "Η διεύθυνση είναι υποχρεωτική" : "");
				
				errorStreetNumber.setText(streetNumber.equals("") ? "Ο αριθμός διεύθυνσης είναι υποχρεωτικός" : "");
				
				errorZipCode.setText(zipcode.equals("") ? "Ο ΤΚ είναι υποχρεωτικός" : "");

				// Return if any field is empty
				if (selectedCity == null || firstname.equals("") || lastname.equals("") || vat.equals("") || fathername.equals("")|| phoneNumber.equals("")||email.equals("") || street.equals("")|| streetNumber.equals("")|| zipcode.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
               
				
				// Insert
				
				String sql = "INSERT INTO teachers (firstname, lastname, vat, fathername, phone_num, "
            			+ "email, street, street_num, zipcode, city_id, uuid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
            	Connection conn = Dashboard.getConnection();
            	
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, vat);
					ps.setString(4, fathername);
					ps.setString(5, phoneNumber);
					ps.setString(6, email);
					ps.setString(7, street);
					ps.setString(8, streetNumber);
					ps.setString(9, zipcode);
					ps.setInt(10,cityId);
					
					String uuid = UUID.randomUUID().toString();
				    ps.setString(11, uuid);
					
					int n = ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,  n + " record(s) inserted", "INSERT", JOptionPane.PLAIN_MESSAGE);	
				} catch (SQLException e1) {			
				    e1.printStackTrace();
					JOptionPane.showMessageDialog(null,  "Insertion error", "Error", JOptionPane.ERROR_MESSAGE);
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
				Main.getInsertTeacherPage().setVisible(false);
				Main.getDashboard().setEnabled(true);
			}
		});

		closeBtn.setForeground(new Color(0, 0, 0));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeBtn.setBackground(new Color(192, 192, 192));
		closeBtn.setBounds(91, 485, 263, 54);
		contentPane.add(closeBtn);	
		
		
		
		
		
	
		
		
	
	}
	
	private List<City> fetchCitiesFromDatabase() {
		String sql = "SELECT * FROM cities order by name asc";
		List<City> cities = new ArrayList();
		
		Connection connection = Dashboard.getConnection();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				City city = new City(id, name);
				cities.add(city);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,  "Select cities error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return cities;
	}
}