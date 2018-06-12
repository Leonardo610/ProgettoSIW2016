package it.clinic.persistence;

import java.util.List;

import it.clinic.model.Prerequisite;

public interface PrerequisiteDao {
	public void save(Prerequisite prerequisite); //Create
	
	public void delete(Prerequisite prerequisite); //Delete
	
	public void update(Prerequisite prerequisite); //Update
	
	public List<Prerequisite> findAll(); 
	
	public Prerequisite findByPrimaryKey(String name); //Retrieve

}
