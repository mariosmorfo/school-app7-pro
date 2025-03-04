package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public LoginPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/eduv2.png")));
		setTitle("Αυθεντικοποίηση Χρήστη");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnect = new JLabel("Σύνδεση");
		lblConnect.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConnect.setBounds(193, 11, 62, 39);
		contentPane.add(lblConnect);
		
		JLabel lblMessage = new JLabel("Παρακαλώ εισάγετε τους κωδικούς σας για να συνδεθείτε");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMessage.setBounds(100, 52, 293, 31);
		contentPane.add(lblMessage);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(91, 90, 293, 17);
		contentPane.add(separator);
		
		username = new JTextField();
		username.setBounds(138, 121, 174, 31);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUser = new JLabel("Χρήστης :");
		lblUser.setBounds(138, 99, 87, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Κωδικός :");
		lblPassword.setBounds(138, 160, 87, 14);
		contentPane.add(lblPassword);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConnect.setBackground(new Color(0, 128, 0));
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				if((username.getText().matches("[aA]dmin"))&& Arrays.equals(password.getPassword(), "12345".toCharArray())) {
					Main.getLoginpage().setVisible(false);
					Main.getDashboard().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Λάθος username", "Αδυναμία σύνδεσης", JOptionPane.ERROR_MESSAGE);
					username.setText("");
					password.setText("");
				}
		
			}
		});
		btnConnect.setBounds(138, 231, 174, 31);
		contentPane.add(btnConnect);
		
		password = new JPasswordField();
		
		password.setBounds(138, 182, 174, 31);
		contentPane.add(password);
	}
}
