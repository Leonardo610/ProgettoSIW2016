package it.clinic.persistence;

import java.util.List;

import it.clinic.model.Medic;

public interface MedicDao {
	
	
	public void save(Medic medic); //save
	
	public void delete(Medic medic); //Delete
	
	public void update(Medic medic); //Update
	
	public List<Medic> findAll(); 
	
	public Medic findByPrimaryKey(Long id); //Retrieve
	public Medic findByCodice(String code);
}
