package swing_login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import article.Article;
import article.ArticleDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Blog_page extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blog_page frame = new Blog_page("");
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
	public Blog_page(String email_saisie) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(381, 11, 556, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + email_saisie);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.ITALIC, 40));
		lblNewLabel.setBounds(10, 11, 536, 75);
		panel.add(lblNewLabel);
		
		JPanel afficher_article = new JPanel();
		afficher_article.setBounds(661, 150, 556, 552);
		contentPane.add(afficher_article);
		afficher_article.setLayout(null);
		
		JLabel titrelbl = new JLabel("");
		titrelbl.setBounds(10, 11, 536, 68);
		afficher_article.add(titrelbl);
		

		
		JEditorPane articlelbl = new JEditorPane();
		articlelbl.setBounds(10, 100, 546, 276);
		articlelbl.setEditable(false);
		afficher_article.add(articlelbl);
		
		JLabel resumelbl = new JLabel("");
		resumelbl.setEnabled(false);
		resumelbl.setBounds(10, 391, 536, 150);
		afficher_article.add(resumelbl);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(37, 187, 556, 515);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 524, 54);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Liste des Articles");
		lblNewLabel_1.setFont(new Font("Stencil", Font.ITALIC, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 524, 54);
		panel_2.add(lblNewLabel_1);
		
		JButton btnCreerArticle = new JButton("Ecrire un Article");
		btnCreerArticle.setFont(new Font("Stencil", Font.ITALIC, 20));
		btnCreerArticle.setBounds(35, 427, 253, 46);
		panel_1_1.add(btnCreerArticle);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = table.getSelectedRow();
				
				String artID =  table.getModel().getValueAt(id, 0).toString();
				String artTitre =  table.getModel().getValueAt(id, 1).toString();
				String artArticle =  table.getModel().getValueAt(id, 2).toString();
				String artResume =  table.getModel().getValueAt(id, 3).toString();
			System.out.println(table.getSelectedRow());
			
				
				titrelbl.setText(artTitre);
				articlelbl.setText(artArticle);
				resumelbl.setText(artResume);
				
			}
		});
		table.setBounds(35, 76, 467, 268);
		panel_1_1.add(table);
		table.setModel(liste());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 76, 465, 268);
		panel_1_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Cliquer sur l'article à lire");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Stencil", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(35, 362, 467, 54);
		panel_1_1.add(lblNewLabel_2);
		
	}
	public DefaultTableModel liste(){
		
		String [] col = {"ID", "Titre", "Article", "Resume"};
		
		ArticleDAO artDAO = new ArticleDAO();
		
		DefaultTableModel tab = new DefaultTableModel(null, col);
		
		List<Article> listArticles = new ArrayList<>();
		listArticles.addAll(artDAO.read());
		
		for (int i = 0; i < listArticles.size(); i++) {
			Article art = listArticles.get(i);
			
			Vector vect = new Vector();
			vect.add(art.getId());
			vect.add(art.getTitre());
			vect.add(art.getArticle());
			vect.add(art.getResume());
			
			tab.addRow(vect);
		}
		return tab;

	}
}

























