package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import getConnect.GetConnect;
import user.User;
import user.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import user.UserDao;
import dao.IDAO;


public class Login extends JFrame {

	protected static final GetConnect getConnect = null;
	private JPanel contentPane;
	private JTextField emailConnection;
	private JPasswordField passewordConnection;
	private JPasswordField passwordCreate;
	private JTextField emailCreate;
	private JTextField prenomCreate;
	private JTextField nomCreate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBounds(80, 27, 1083, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur le Blog CDA 314");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.ITALIC, 30));
		lblNewLabel.setBounds(-18, 0, 1101, 66);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 93, 374, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9j\u00E0 Client ?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 0, 354, 47);
		panel_1.add(lblNewLabel_1);
		
		emailConnection = new JTextField();
		emailConnection.setBounds(10, 92, 344, 57);
		panel_1.add(emailConnection);
		emailConnection.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email ?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(20, 46, 172, 35);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password ?");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(10, 177, 172, 35);
		panel_1.add(lblNewLabel_2_1);
		
		passewordConnection = new JPasswordField();
		passewordConnection.setBounds(10, 223, 344, 57);
		panel_1.add(passewordConnection);
		
		
		Connection connect = GetConnect.getConnection();
		
		JButton btnConnection = new JButton("Connection");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email_saisie = emailConnection.getText();
				String password_saisie = passewordConnection.getText();
				
				try {
					
					PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=? " + " AND password=?");
					
					req.setString(1, email_saisie);
					req.setString(2, password_saisie);
					
					ResultSet rs = req.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnConnection, "Welcome " + email_saisie);
						
						dispose();
						
						Blog_page home = new Blog_page(email_saisie);
						home.setVisible(true);
						
						JLabel user = new JLabel(email_saisie);
						home.getContentPane().add(user);
						
					}else {
						JOptionPane.showMessageDialog(btnConnection, "Login / mdp incorrect");

					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
					System.out.println("Insertion KO - KO - KO");
				}
			}
		});
		btnConnection.setFont(new Font("Stencil", Font.ITALIC, 20));
		btnConnection.setBounds(10, 303, 344, 47);
		panel_1.add(btnConnection);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(850, 93, 374, 561);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cr\u00E9er un Compte");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(10, 0, 354, 35);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nom");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2_2.setBounds(26, 46, 172, 35);
		panel_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Prenom");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_3.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2_3.setBounds(26, 164, 172, 35);
		panel_1_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Email");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_4.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2_4.setBounds(26, 274, 172, 35);
		panel_1_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Password");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_5.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2_5.setBounds(26, 388, 172, 35);
		panel_1_1.add(lblNewLabel_2_5);
		
		passwordCreate = new JPasswordField();
		passwordCreate.setBounds(20, 430, 344, 57);
		panel_1_1.add(passwordCreate);
		
		emailCreate = new JTextField();
		emailCreate.setColumns(10);
		emailCreate.setBounds(20, 320, 344, 57);
		panel_1_1.add(emailCreate);
		
		prenomCreate = new JTextField();
		prenomCreate.setColumns(10);
		prenomCreate.setBounds(20, 206, 344, 57);
		panel_1_1.add(prenomCreate);
		
		nomCreate = new JTextField();
		nomCreate.setColumns(10);
		nomCreate.setBounds(20, 92, 344, 57);
		panel_1_1.add(nomCreate);
		
		JButton btnCreate = new JButton("Créer Votre Compte");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String saisie_nom = nomCreate.getText();
				String saisie_prenom = prenomCreate.getText();
				String saisie_email = emailCreate.getText();
				String saisie_password = passwordCreate.getText();
				
				User us = new User(saisie_nom,saisie_prenom,saisie_email,saisie_password);
				UserDao userDao = new UserDao();
				
				if (saisie_nom.equals("") || saisie_prenom.equals("") || saisie_email.equals("") || saisie_password.equals("")) {
					JOptionPane.showMessageDialog(btnCreate, "Veuillez remplir tous les champs");
					
				}else {
					try {
						
						PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=? ");
						
						req.setString(1, saisie_email);
						ResultSet rs = req.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(btnCreate, "Cet Email existe déjà !");
							
						}else {
							userDao.create(us);
							JOptionPane.showMessageDialog(btnCreate, "Votre Compte a bien été créer");
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
						System.out.println("Erreur 123345 !!!!!!!!");
					}
				}
					nomCreate.setText("");
					prenomCreate.setText("");
					emailCreate.setText("");
					passwordCreate.setText("");
				}
		});
		
		btnCreate.setFont(new Font("Stencil", Font.ITALIC, 20));
		btnCreate.setBounds(20, 498, 344, 47);
		panel_1_1.add(btnCreate);
		setLocationRelativeTo(null);
	}
}




