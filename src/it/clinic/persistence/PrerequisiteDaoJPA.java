package it.clinic.persistence;

import java.util.List;


import javax.persistence.EntityManager;
import it.clinic.model.Prerequisite;


public class PrerequisiteDaoJPA implements PrerequisiteDao {
	private EntityManager em;
	
   	public PrerequisiteDaoJPA(EntityManager em){
   		this.em=em;
   	}


	@Override
	public void save(Prerequisite prerequisite) {
		em.persist(prerequisite);
	}

	@Override
	public void delete(Prerequisite prerequisite) {
		em.remove(prerequisite);
	}

	@Override
	public void update(Prerequisite prerequisite) {
		em.merge(prerequisite);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisite> findAll() {
		List<Prerequisite> prerequisites= em.createNamedQuery("allPrerequisites").getResultList();
		return prerequisites;
	}

	@Override
	public Prerequisite findByPrimaryKey(String name) {
		return em.find(Prerequisite.class, name);
	}

}
