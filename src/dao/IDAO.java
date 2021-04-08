package dao;

import java.util.List;


public interface IDAO<T> {
	
	public boolean ecrire(T object);
	public void create(T object);
	public List<T> read();
	public List<T> findById();
	public void update(T object);
	public void delete(T object);


}
