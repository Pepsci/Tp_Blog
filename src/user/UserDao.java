package user;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.ActionMap;
import javax.swing.JOptionPane;

import dao.IDAO;
import getConnect.GetConnect;
import swing.Login;

public class UserDao implements IDAO<User>{

	Connection connect = GetConnect.getConnection();
	
	@Override
	public void create(User object) {

		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user"
					+ "(nom, prenom, email, password) VALUE (?,?,?,?)");
			
			req.setString(1, object.getNomCreate());
			req.setString(2, object.getPrenomCreate());
			req.setString(3, object.getEmailCreate());
			req.setString(4, object.getPassewordCreate());
			
			req.executeUpdate();
			System.out.println("User ajouté !");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur Insertion");
		}
		
	}

	@Override
	public List<User> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User object) {
		// TODO Auto-generated method stub
		
	}

}







	
	

