package it.clinic.persistence;

import java.util.List;

import it.clinic.model.ExamTypology;

public interface ExamTypologyDao {

	public void save(ExamTypology typology); //Save

	public void update(ExamTypology typology); //Update

	public void delete(ExamTypology typology); //Delete
	public List<ExamTypology> findAll();
	
	public ExamTypology findByPrimaryKey(Long id); //Retrieve
	public ExamTypology findByName(String name);


}