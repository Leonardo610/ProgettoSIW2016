package it.clinic.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinic.model.Medic;


public class MedicDaoJPA implements MedicDao{
	private EntityManager em;
	
   	public MedicDaoJPA(EntityManager em){
   		this.em=em;
   	}
 


	@Override
	public void save(Medic medic) {
		em.persist(medic);
	}



	@Override
	public void delete(Medic medic) {
		em.remove(medic);
	}

	@Override
	public void update(Medic medic) {
		em.merge(medic);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medic> findAll() {
		List<Medic> medics = em.createNamedQuery("allMedics").getResultList();
		return medics;
	}

	@Override
	public Medic findByPrimaryKey(Long id) {
		return em.find(Medic.class, id);
	}

	@Override
	public Medic findByCodice(String codice) {
		Query query = em.createQuery("SELECT m FROM Medic m WHERE m.code=?");
		return (Medic)query.setParameter(1,codice).getSingleResult();
	}


}
