package commentaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import getConnect.GetConnect;

public class CommentaireDAO implements IDAO<Commentaire>{

	Connection connect = GetConnect.getConnection();
	
	@Override
	public boolean ecrire(Commentaire object) {
		boolean message = false;
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO commentaire"
					+ "(commentaire, auteur, article_id) VALUES (?,?,?) ");
			
			req.setString(1, object.getCommentaire());
			req.setString(2, object.getAuteur());
			req.setInt(3, object.getArticle_id());
			
			req.executeUpdate();
			message = false;
			System.out.println("Commentaire OK");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Commentaire KO");
			
		}
		return message;
		
	}
	
	public List<Commentaire> findById(int id) {
		List<Commentaire> listeCommentaire = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM commentaire WHERE article_id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Commentaire commentaire = new Commentaire();
				
				commentaire.setId(rs.getInt("id"));
				commentaire.setCommentaire(rs.getString("commentaire"));
				commentaire.setAuteur(rs.getString("auteur"));
				commentaire.setArticle_id(rs.getInt("article_id"));
				
				listeCommentaire.add(commentaire);
			}
			System.out.println(listeCommentaire);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeCommentaire;
	}

	@Override
	public List<Commentaire> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Commentaire object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commentaire object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Commentaire object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
