package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Tipologiasexo;
import model.Valoracionmateria;

public class ControladorValoracionMateria {

	private static ControladorValoracionMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstance() {
		if (instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}

	public ControladorValoracionMateria() {
		
	}

	/**
	 * 
	 * @return
	 */
	
	public List<Valoracionmateria> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria", Valoracionmateria.class);
		
		List<Valoracionmateria> list = (List<Valoracionmateria>) q.getResultList();
		em.close();
		return list;
	}
}
