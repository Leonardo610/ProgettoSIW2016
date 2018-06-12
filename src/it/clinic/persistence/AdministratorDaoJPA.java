package it.clinic.persistence;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinic.model.Administrator;


public class AdministratorDaoJPA implements AdministratorDao {
	
   	private EntityManager em;
	
   	public AdministratorDaoJPA(EntityManager em){
   		this.em=em;
   	}
	
	@Override
	public void save(Administrator administrator) {
		em.persist(administrator);
	}

	@Override
	public void delete(Administrator administrator) {
		em.remove(administrator);
	}

	@Override
	public void update(Administrator administrator) {
		em.merge(administrator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findAll() {
		List<Administrator> administrators = em.createNamedQuery("allAdministrators").getResultList();
		return administrators;
	}

	@Override
	public Administrator findByPrimaryKey(Long id) {
		return em.find(Administrator.class, id);
	}
	
	@Override
	public Administrator findByUsername(String username){
		Query query = em.createQuery("SELECT a FROM Administrator a WHERE a.username=?");
		return (Administrator)query.setParameter(1,username).getSingleResult();
	}
	
	@Override
	public Administrator findAdmin(String username, String password){
		Query query = em.createQuery("SELECT a FROM Administrator a WHERE a.username='"+ username + "' AND a.pwd='"+password+"'");
		Administrator administrator = (Administrator)query.getSingleResult();
		return administrator;
	}
}