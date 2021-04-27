package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tipologiasexo;

public class ControladorTipologiaSexo {
	private static ControladorTipologiaSexo instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipologiaSexo getInstance () {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	public List<Tipologiasexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiaSexo", Tipologiasexo.class);
		
		List<Tipologiasexo> list = (List<Tipologiasexo>) q.getResultList();
		em.close();
		return list;
	}

}
