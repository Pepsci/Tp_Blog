package swing_login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CreationArticle extends JFrame {

	private JPanel contentPane;
	private JTextField titreArticle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationArticle frame = new CreationArticle();
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
	public CreationArticle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 835);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 109, 619, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane article = new JTextPane();
		article.setBounds(10, 76, 599, 591);
		panel.add(article);
		
		JLabel lblNewLabel_1 = new JLabel("Votre Article");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Stencil", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(10, 11, 599, 42);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 619, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setFont(new Font("Stencil", Font.ITALIC, 30));
		lblNewLabel.setBounds(10, 21, 105, 38);
		panel_1.add(lblNewLabel);
		
		titreArticle = new JTextField();
		titreArticle.setBounds(130, 21, 465, 38);
		panel_1.add(titreArticle);
		titreArticle.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(639, 11, 648, 325);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("R\u00E9sum\u00E9");
		lblNewLabel_2.setFont(new Font("Stencil", Font.ITALIC, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 628, 48);
		panel_2.add(lblNewLabel_2);
		
		JTextPane resumeArticle = new JTextPane();
		resumeArticle.setBounds(10, 62, 628, 252);
		panel_2.add(resumeArticle);
		
		JButton btnEnvoyerArticle = new JButton("Envoyer");
		btnEnvoyerArticle.setFont(new Font("Stencil", Font.ITALIC, 30));
		btnEnvoyerArticle.setBounds(639, 347, 314, 60);
		contentPane.add(btnEnvoyerArticle);
		
		JButton btnRetourArticles = new JButton("Retour Articles");
		btnRetourArticles.setFont(new Font("Stencil", Font.ITALIC, 30));
		btnRetourArticles.setBounds(639, 445, 314, 60);
		contentPane.add(btnRetourArticles);
	}

}
