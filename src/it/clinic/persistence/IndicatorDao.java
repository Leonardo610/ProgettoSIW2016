package it.clinic.persistence;
import java.util.List;

import it.clinic.model.Indicator;

public interface IndicatorDao {

	public void save(Indicator indicator); //Create
	public void delete(Indicator indicator); //Delete
	public void update(Indicator indicator); //Update
	public List<Indicator> findAll(); 
	public Indicator findByPrimaryKey(Long id); //Retrieve
	public Indicator findByName(String name);
}