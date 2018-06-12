package it.clinic.persistence;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinic.model.Indicator;



public class IndicatorDaoJPA implements IndicatorDao {
	private EntityManager em;
	
   	public IndicatorDaoJPA(EntityManager em){
   		this.em=em;
   	}
		
	@Override
	public void save(Indicator indicator) {
		em.persist(indicator);
	}

	@Override
	public void delete(Indicator indicator) {
		em.remove(indicator);
	}

	@Override
	public void update(Indicator indicator) {
		em.merge(indicator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Indicator> findAll() {
		List<Indicator> indicators = em.createNamedQuery("allIndicators").getResultList();
		return indicators;
	}

	@Override
	public Indicator findByPrimaryKey(Long id) {
		return em.find(Indicator.class, id);
	}
	
	@Override
	public Indicator findByName(String name){
		Query query = em.createQuery("SELECT i FROM Indicator i WHERE i.name=?");
		query.setParameter(1, name);
		return (Indicator) query.getSingleResult();
	}

}