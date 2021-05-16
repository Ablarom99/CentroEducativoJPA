package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Profesor;
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
	public boolean findByEstudianteAndProfesorAndMateria (Profesor profesor, Materia materia, Estudiante estudiante, int nota) {
		EntityManager em = factory.createEntityManager();
		boolean encontrado = false;
		try {
			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria "
					+ "WHERE idProfesor = ? AND idEstudiante = ? AND idMateria = ? AND ROUND(valoracion) = ? ;", Valoracionmateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, estudiante.getId());
			q.setParameter(3, materia.getId());
			q.setParameter(4, nota);
			
			if (q.getSingleResult() != null)
				encontrado = true;
			return encontrado;
			
		} catch (Exception e) {
			//System.out.println("No existe el valor"); //Muestra por pantalla al pulsar
			encontrado = false;
			return false;
		}
	
	}
	public boolean guardar(Valoracionmateria valoracionMateria) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (valoracionMateria.getId() == 0) {
				em.persist(valoracionMateria);
			} else {
				em.merge(valoracionMateria);
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Guardar");
			return false;
		}
		return true;
	}
	public Valoracionmateria findEstProfMat (Profesor profesor, Materia materia, Estudiante estudiante) {
		Valoracionmateria resultado = null;
		EntityManager em = factory.createEntityManager();
		 
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", Valoracionmateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			resultado = (Valoracionmateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return resultado;
	}
//	public Valoracionmateria findByMateriaAndProfesorAndEstudianteAndValoracion (Materia m, Profesor p, Estudiante e, float v) {
//		Valoracionmateria resultado = null;
//		try {
//			EntityManager em = this.factory.createEntityManager();
//			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idMateria = ? and "
//					+ "idProfesor = ? and idEstudiante = ? and valoracion = ?", Valoracionmateria.class);
//			q.setParameter(1, m.getId());
//			q.setParameter(2, p.getId());
//			q.setParameter(3, e.getId());
//			q.setParameter(4, v);
//			resultado = (Valoracionmateria) q.getSingleResult();
//			em.close();
//		}
//		catch (NoResultException nrEx) {
//		}
//		return resultado;
//	}
	
}
