package it.clinic.persistence;

import java.util.List;

import it.clinic.model.Administrator;

public interface AdministratorDao{
	
	public void save(Administrator administrator); //Create
	
	public void delete(Administrator administrator); //Delete
	
	public void update(Administrator administrator); //Update
	
	public List<Administrator> findAll(); 
	
	public Administrator findByPrimaryKey(Long id); //Retrieve
	public Administrator findByUsername(String username);
	public Administrator findAdmin(String username, String password);
}


