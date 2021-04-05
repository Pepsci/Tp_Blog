package article;

import java.awt.Component;
import swing_login.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ActionMap;
import javax.swing.JOptionPane;

import dao.IDAO;
import getConnect.GetConnect;

public class ArticleDAO implements IDAO<Article>{
	
	Connection connect = GetConnect.getConnection();

	@Override
	public void create(Article object) {

		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO article"
					+ "(titre, article, resume) VALUE (?,?,?)");
			
			req.setString(1, object.getTitre());
			req.setString(2, object.getArticle());
			req.setString(3, object.getResume());
			
			req.executeUpdate();
			System.out.println("Article ajouté !");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur ajout");
		}
	}

	@Override
	public List<Article> read() {
		List<Article> listArticles = new ArrayList<>();
		
		try {
			
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			
			while (rs.next()) {
				Article art = new Article();
				
				art.setId(rs.getInt("id"));
				art.setTitre(rs.getString("titre"));
				art.setArticle(rs.getString("article"));
				art.setResume(rs.getString("resume"));
				
				
				listArticles.add(art);
			}
			System.out.println(listArticles);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listArticles;
	}

	@Override
	public void update(Article object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Article object) {
		// TODO Auto-generated method stub
		
	}
	
	

}
