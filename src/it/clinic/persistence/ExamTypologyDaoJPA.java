package it.clinic.persistence;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinic.model.ExamTypology;



public class ExamTypologyDaoJPA implements ExamTypologyDao {
	private EntityManager em;
	
	
	public ExamTypologyDaoJPA(EntityManager em) {
		this. em = em;
	}



	@Override
	public void save(ExamTypology examTypology) {
		em.persist(examTypology);

	}
	@Override
	public void update(ExamTypology examTypology) {
		em.merge(examTypology);

	}

	@Override
	public void delete(ExamTypology examTypology) {
		em.remove(examTypology);

	}

	@Override
	public ExamTypology findByPrimaryKey(Long id) {
		ExamTypology examTypology = em.find(ExamTypology.class,id);
		return examTypology;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ExamTypology> findAll() {
		List<ExamTypology> examTypologies = em.createNamedQuery("allExamsTypologies").getResultList();
		return examTypologies;
	}


	@Override
	public ExamTypology findByName(String name) {
		Query query = em.createQuery("SELECT t FROM ExamTypology t WHERE t.name=?");
		query.setParameter(1, name);
		return (ExamTypology) query.getSingleResult();
	}
}


