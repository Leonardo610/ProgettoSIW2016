package it.clinic.persistence;

import java.util.List;
import java.util.Map;

import it.clinic.model.Exam;
import it.clinic.model.Indicator;

public interface ExamDao {
	
	public void save(Exam exam); //Create
	
	public void delete(Exam exam); //Delete
	
	public void update(Exam exam); //Update
	
	public List<Exam> findAll(); 
	
	public Exam findByPrimaryKey(Long id); //Retrieve
	public 	Map<Indicator,String> findExamResults(Long id);
	public List<Exam> findAllByMedicId(Long medicId);
}