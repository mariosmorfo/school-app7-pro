package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;
	
	public Dashboard() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String sql = "jdbc:mysql://localhost:3306/school7dbpro?serverTimezone=UTC";
				String username = "user7pro";
				String password = "12345";
				
				try {
					connection = DriverManager.getConnection(sql, username, password);
					System.out.println("Connection success");
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/eduv2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 746, 56);
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(Dashboard.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(10, 0, 154, 56);
		header.add(govImage);
		
		JLabel firstLastName = new JLabel("Μάριος Μορφονίδης");
		firstLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstLastName.setForeground(new Color(255, 255, 255));
		firstLastName.setBounds(584, 11, 123, 34);
		header.add(firstLastName);
		
		JPanel footer = new JPanel();
		footer.setBounds(0, 378, 746, 97);
		footer.setLayout(null);
		contentPane.add(footer);
		
		JLabel lblManual = new JLabel("Εγχειρίδιο Χρήσης");
		lblManual.setForeground(Color.BLUE);
		lblManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManual.setBounds(85, 32, 112, 34);
		footer.add(lblManual);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setForeground(Color.BLUE);
		lblQuestions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuestions.setBounds(307, 32, 112, 34);
		footer.add(lblQuestions);
		
		JLabel lblSupport = new JLabel("Υποστήριξη Πολιτών");
		lblSupport.setForeground(Color.BLUE);
		lblSupport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupport.setBounds(529, 32, 112, 34);
		footer.add(lblSupport);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setBounds(0, 2, 746, 1);
		footer.add(separator);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(0, 52, 117));
		sideMenu.setBounds(0, 54, 145, 326);
		contentPane.add(sideMenu);
		sideMenu.setLayout(null);
		
		JLabel lbl_home = new JLabel("Αρχική");
		lbl_home.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_home.setForeground(new Color(255, 255, 0));
		lbl_home.setBounds(10, 11, 45, 35);
		sideMenu.add(lbl_home);
		
		JLabel lbl_teachers = new JLabel("Εκπαιδευτές");
		lbl_teachers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_teachers.setForeground(new Color(255, 255, 255));
		lbl_teachers.setBounds(10, 37, 73, 29);
		sideMenu.add(lbl_teachers);
		
		JLabel lbl_teachersView = new JLabel("Προβολή εκπαιδευτών");
		lbl_teachersView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teachersView.setText("<html><font color='blue'>Προβολή Εκπαιδευτών</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teachersView.setText("Προβολή Εκπαιδευτών");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getViewTeachersPage().setVisible(true);
			}
		});
		lbl_teachersView.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_teachersView.setForeground(new Color(255, 255, 255));
		lbl_teachersView.setBounds(20, 57, 110, 29);
		sideMenu.add(lbl_teachersView);
		
		JLabel lbl_teachersInsert = new JLabel("Εισαγωγή Εκπαιδευτή");
		lbl_teachersInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teachersInsert.setText("<html><font color='blue'>Εισαγωγή Εκπαιδευτή</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teachersInsert.setText("Εισαγωγή Εκπαιδευτή");
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});
		lbl_teachersInsert.setBounds(20, 82, 119, 30);
		sideMenu.add(lbl_teachersInsert);
		lbl_teachersInsert.setForeground(new Color(255, 255, 255));
		lbl_teachersInsert.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel = new JLabel("Ποιότητα στην εκπαίδευση");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(340, 90, 261, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Προβολή Μητρώου Εκπαιδευτών");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(181, 135, 216, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Προβολή Μητρώου Εγγεγραμμένων Εκπαιδευτών στο Μητρώο του Coding Factory");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(181, 162, 515, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο Εκπαιδευτών");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(181, 236, 405, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο του Coding Factory\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(181, 263, 377, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1_1 = new JButton("Εισαγωγή");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
				
				
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1_1.setBounds(181, 288, 89, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Συνέχεια");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getViewTeachersPage().setVisible(true);
			}
		});
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1_1_1.setBounds(181, 194, 89, 31);
		contentPane.add(btnNewButton_1_1_1);
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
		
	}
	
