package it.clinic.persistence;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.clinic.model.Exam;
import it.clinic.model.Indicator;


public class ExamDaoJPA implements  ExamDao{
	private EntityManager em;
	
   	public ExamDaoJPA(EntityManager em){
   		this.em=em;
   	}



	@Override
	public void save(Exam exam) {
		em.persist(exam);
	}

	@Override
	public void delete(Exam exam) {
		em.remove(exam);
	}

	@Override
	public void update(Exam exam) {
		em.merge(exam);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> findAll() {
		List<Exam> exams = em.createNamedQuery("allExams").getResultList();
		return exams;
	}

	@Override
	public Exam findByPrimaryKey(Long id) {
		return em.find(Exam.class, id);
	}

	@Override
	public Map<Indicator, String> findExamResults(Long id) {
		Exam exam = this.findByPrimaryKey(id);
		return exam.getResults();
	}
	
	@SuppressWarnings("unchecked")
	public List<Exam> findAllByMedicId(Long medicId){
		List<Exam> exams = null;
		Query query = em.createQuery("SELECT e FROM Exam e WHERE e.medic.id= :medicId");
		try{
			query.setParameter("medicId", medicId);
			exams = query.getResultList();
		} catch(NoResultException e){}
		return exams;
	}
	
	@SuppressWarnings("unchecked")
	public List<Exam> findAllByPatient(Long idpatient){
		List<Exam> exams = null;
	Query query = em.createQuery("SELECT e FROM Exam e WHERE e.patient.id= :patientId");
	try{
		query.setParameter("patientId", idpatient);
		exams = query.getResultList();
	} catch(NoResultException e){}
	return exams;
}
}
