package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;

	public Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/eduv2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 693);
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
		footer.setBounds(0, 554, 746, 86);
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
		sideMenu.setBounds(0, 54, 145, 502);
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

		JLabel lbl_studentsInsert = new JLabel("Εισαγωγή Μαθητή");
		lbl_studentsInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_studentsInsert.setText("<html><font color='blue'>Εισαγωγή Μαθητή</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_studentsInsert.setText("Εισαγωγή Μαθητή");
			}


			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertStudentPage().setVisible(true);
			}
		});
		lbl_studentsInsert.setForeground(Color.WHITE);
		lbl_studentsInsert.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_studentsInsert.setBounds(20, 136, 119, 30);
		sideMenu.add(lbl_studentsInsert);

		JLabel lbl_studentsView = new JLabel("Προβολή Μαθητών");
		lbl_studentsView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_studentsView.setText("<html><font color='blue'>Προβολή Μαθητών</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_studentsView.setText("Προβολή Μαθητών");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getViewTeachersPage().setVisible(true);
			}
		});
		lbl_studentsView.setForeground(Color.WHITE);
		lbl_studentsView.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_studentsView.setBounds(20, 110, 119, 30);
		sideMenu.add(lbl_studentsView);

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

		JButton insertTeacher = new JButton("Εισαγωγή");
		insertTeacher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		insertTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);


			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("Προβολή Μητρώου Μαθητών");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(181, 330, 216, 41);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Προβολή Μητρώου Εγγεγραμμένων Μαθητών στο Μητρώο του Coding Factory");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(181, 353, 515, 31);
		contentPane.add(lblNewLabel_2_1);

		JButton btnNewButton_1_1_1_1 = new JButton("Συνέχεια");
//		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Main.getDashboard().setEnabled(false);
//				Main.getInsertTeacherPage().setVisible(true);
//
//
//			}
//		});

		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1_1_1_1.setBounds(181, 382, 89, 31);
		contentPane.add(btnNewButton_1_1_1_1);
		insertTeacher.setForeground(new Color(255, 255, 255));
		insertTeacher.setBackground(new Color(0, 128, 0));
		insertTeacher.setBounds(181, 288, 89, 31);
		contentPane.add(insertTeacher);

		JButton viewTeacher = new JButton("Συνέχεια");
//		viewTeacher.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Main.getDashboard().setEnabled(false);
//				Main.getViewTeachersPage().setVisible(true);
//			}
//		});
		viewTeacher.setForeground(Color.WHITE);
		viewTeacher.setBackground(new Color(0, 128, 0));
		viewTeacher.setBounds(181, 194, 89, 31);
		contentPane.add(viewTeacher);

		JLabel lblNewLabel_3_1 = new JLabel("Εισαγωγή Μαθητή στο Μητρώο Εκπαιδευτών");
		lblNewLabel_3_1.setBounds(181, 417, 405, 31);
		contentPane.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_4_1 = new JLabel("Εισαγωγή Μαθητή στο Μητρώο του Coding Factory\r\n");
		lblNewLabel_4_1.setBounds(181, 444, 377, 14);
		contentPane.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton insertStudent = new JButton("Εισαγωγή");
		insertStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertStudentPage().setVisible(true);


			}
		});
		insertStudent.setBounds(181, 468, 89, 31);
		contentPane.add(insertStudent);
		insertStudent.setForeground(Color.WHITE);
		insertStudent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		insertStudent.setBackground(new Color(0, 128, 0));
	}




}

