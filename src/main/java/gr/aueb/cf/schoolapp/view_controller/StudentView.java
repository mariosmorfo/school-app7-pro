package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.model.City;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class StudentView extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel kwdikosText;
    private JLabel firstnameText;
    private JLabel lastnameText;
    private JLabel fathernameText;
    private JLabel phoneNumText;
    private JLabel emailText;
    private JLabel streetText;
    private JLabel streetNumText;
    private JLabel cityText;
    private JLabel zipcodeText;

    private List<City> cities = new ArrayList<>();


    public StudentView() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {

                cities = fetchCitiesFromDatabase();
                fetchStudentFromDatabase(Main.getViewStudentPage().getSelectedId());
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 753, 714);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Αίτηση Μαθητή");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(258, 81, 272, 41);
        contentPane.add(lblNewLabel);

        JLabel lblKwdikos = new JLabel("Κωδικός Μαθητή");
        lblKwdikos.setBounds(70, 155, 128, 27);
        contentPane.add(lblKwdikos);

        kwdikosText = new JLabel("Κωδικός Μαθητή");
        kwdikosText.setBounds(277, 155, 128, 27);
        contentPane.add(kwdikosText);

        JLabel lblFirstname = new JLabel("Όνομα Εκπαιδευτή");
        lblFirstname.setBounds(70, 180, 128, 27);
        contentPane.add(lblFirstname);

        firstnameText = new JLabel("Όνομα Εκπαιδευτή");
        firstnameText.setBounds(277, 180, 128, 27);
        contentPane.add(firstnameText);

        JLabel lblLastname = new JLabel("Επώνυμο Εκπαιδευτή");
        lblLastname.setBounds(70, 207, 128, 27);
        contentPane.add(lblLastname);

        lastnameText = new JLabel("Επώνυμο Εκπαιδευτή");
        lastnameText.setBounds(277, 207, 128, 27);
        contentPane.add(lastnameText);

        JLabel lblVat = new JLabel("ΑΦΜ Εκπαιδευτή");
        lblVat.setBounds(70, 245, 128, 27);
        contentPane.add(lblVat);

        JLabel lblFathername = new JLabel("Πατρώνυμο Εκπαιδευτή");
        lblFathername.setBounds(70, 265, 128, 27);
        contentPane.add(lblFathername);

        JLabel lblPhoneNum = new JLabel("Τηλέφωνο Εκπαιδευτή");
        lblPhoneNum.setBounds(70, 303, 128, 27);
        contentPane.add(lblPhoneNum);

        JLabel lblEmail = new JLabel("e-mail Εκπαιδευτή");
        lblEmail.setBounds(70, 330, 128, 27);
        contentPane.add(lblEmail);

        JLabel lblStreet = new JLabel("Διεύθυνση Εκπαιδευτή");
        lblStreet.setBounds(70, 354, 128, 27);
        contentPane.add(lblStreet);

        fathernameText = new JLabel("Πατρώνυμο Εκπαιδευτή");
        fathernameText.setBounds(277, 265, 128, 27);
        contentPane.add(fathernameText);

        phoneNumText = new JLabel("Τηλέφωνο Εκπαιδευτή");
        phoneNumText.setBounds(277, 303, 128, 27);
        contentPane.add(phoneNumText);

        emailText = new JLabel("email Εκπαιδευτή");
        emailText.setBounds(277, 330, 128, 27);
        contentPane.add(emailText);

        streetText = new JLabel("Διεύθυνση Εκπαιδευτή");
        streetText.setBounds(277, 354, 128, 27);
        contentPane.add(streetText);

        JLabel lblStreetNum = new JLabel("Αριθμός Διεύθυνσης");
        lblStreetNum.setBounds(70, 378, 128, 27);
        contentPane.add(lblStreetNum);

        streetNumText = new JLabel("Αριθμός Διεύθυνσης");
        streetNumText.setBounds(277, 378, 128, 27);
        contentPane.add(streetNumText);

        JLabel lblCity = new JLabel("Πόλη Εκπαιδευτή");
        lblCity.setBounds(70, 428, 128, 27);
        contentPane.add(lblCity);

        cityText = new JLabel("Πόλη Εκπαιδευτή");
        cityText.setBounds(277, 428, 128, 27);
        contentPane.add(cityText);

        zipcodeText = new JLabel("ΤΚ");
        zipcodeText.setBounds(277, 452, 128, 27);
        contentPane.add(zipcodeText);

        JLabel lblZipcode = new JLabel("ΤΚ");
        lblZipcode.setBounds(70, 452, 128, 27);
        contentPane.add(lblZipcode);

        JButton btnNewButton = new JButton("Κλείσιμο");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getViewTeachersPage().setEnabled(true);
                Main.getTeacherView().setVisible(false);
            }
        });

        btnNewButton.setBounds(469, 471, 134, 57);
        contentPane.add(btnNewButton);

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 233, 597, 1);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(20, 291, 597, 1);
        contentPane.add(separator_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(20, 416, 597, 1);
        contentPane.add(separator_1_1);

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(0, 52, 117));
        header.setBounds(0, 0, 738, 56);
        contentPane.add(header);

        JLabel govImage = new JLabel("");
        govImage.setIcon(new ImageIcon(TeacherView.class.getResource("/images/gov_logo_small.png")));
        govImage.setBounds(10, 0, 154, 56);
        header.add(govImage);

        JLabel firstLastName = new JLabel("Μάριος Μορφονίδης");
        firstLastName.setForeground(Color.WHITE);
        firstLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        firstLastName.setBounds(584, 11, 123, 34);
        header.add(firstLastName);

        JPanel footer = new JPanel();
        footer.setLayout(null);
        footer.setBounds(0, 578, 738, 97);
        contentPane.add(footer);

        JLabel lblManual = new JLabel("Εγχειρίδιο Χρήσης");
        lblManual.setForeground(Color.BLUE);
        lblManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblManual.setBounds(68, 33, 112, 34);
        footer.add(lblManual);

        JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
        lblQuestions.setForeground(Color.BLUE);
        lblQuestions.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblQuestions.setBounds(290, 33, 112, 34);
        footer.add(lblQuestions);

        JLabel lblSupport = new JLabel("Υποστήριξη Πολιτών");
        lblSupport.setForeground(Color.BLUE);
        lblSupport.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSupport.setBounds(512, 33, 112, 34);
        footer.add(lblSupport);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBackground(new Color(0, 128, 255));
        separator_2.setBounds(0, 2, 746, 1);
        footer.add(separator_2);
    }

    private List<City> fetchCitiesFromDatabase(){
//		String sql = "SELECT * FROM cities order by name asc";
//		List<City> cities = new ArrayList<>();
//		Connection conn = Dashboard.getConnection();
//
//		try(PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery()) {
//				while(rs.next()) {
//					int id = rs.getInt("id");
//					String name = rs.getString("name");
//
//					City city = new City (id, name);
//					cities.add(city);
//				}
//
//			}catch(SQLException e) {
//				JOptionPane.showMessageDialog(null, "Select error in fetch cities", "Error", JOptionPane.ERROR_MESSAGE);
//			}
        return cities;
    }


    private void fetchStudentFromDatabase(int id) {
//		String sql = "SELECT * FROM teachers WHERE id = ?";
//		Connection conn = Dashboard.getConnection();
//
//		try(PreparedStatement ps = conn.prepareStatement(sql)){
//
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//
//			if(rs.next()) {
//				kwdikosText.setText(rs.getString("uuid"));
//				firstnameText.setText(rs.getString("firstname"));
//				lastnameText.setText(rs.getString("lastname"));
//				vatText.setText(rs.getString("vat"));
//				fathernameText.setText(rs.getString("fathername"));
//				phoneNumText.setText(rs.getString("phone_num"));
//				emailText.setText(rs.getString("email"));
//				streetText.setText(rs.getString("street"));
//				streetNumText.setText(rs.getString("street_num"));
//				int cityIdFromDB = rs.getInt("city_id");
//
//				City selectedCity = cities.stream()
//					    .filter(city -> city.getId() == cityIdFromDB)
//					    .findFirst()
//					    .orElse(null);
//
//				if (selectedCity != null) {
//				    cityText.setText(selectedCity.getName());
//				}
//
//				zipcodeText.setText(rs.getString("zipcode"));
//				}
//
//			}catch (SQLException e) {
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null,  "Select error in fetch teacher", "Error", JOptionPane.ERROR_MESSAGE);
//			}
//
//

    }

}
