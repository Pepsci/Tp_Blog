package dao;

import java.util.List;


public interface IDAO<T> {
	
	public void create(T object);
	public List<T> read();
	public void update(T object);
	public void delete(T object);


}
