package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Profesor;



public class ControladorEstudiantes {

	 private static ControladorEstudiantes controller = null;
		private static ControladorEstudiantes instance = null;

		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
		
		/**
		 * 
		 * @return
		 */
		public static ControladorEstudiantes getInstance () {
			if (instance == null) {
				instance = new ControladorEstudiantes();
			}
			return instance;
		}
		
		public ControladorEstudiantes() {
			
		}
		
		/**
		 * 
		 * @return
		 */
		public Estudiante findPrimero () {
			Estudiante e = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1", Estudiante.class);
			e = (Estudiante) q.getSingleResult();
			em.close();
			
			return e;
		}
		

		/**
		 * 
		 * @return
		 */
		public Estudiante findUltimo () {
			Estudiante e = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1", Estudiante.class);
			e = (Estudiante) q.getSingleResult();
			em.close();
			
			return e;
		}
		

		/**
		 * 
		 * @return
		 */
		public Estudiante findSiguiente (int idActual) {
			Estudiante e = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1", Estudiante.class);
			q.setParameter(1, idActual);
			e = (Estudiante) q.getSingleResult();
			em.close();
			
			return e;
		}
		

		/**
		 * 
		 * @return
		 */
		public Estudiante findAnterior (int idActual) {
			Estudiante e = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1", Estudiante.class);
			q.setParameter(1, idActual);
			e = (Estudiante) q.getSingleResult();
			em.close();
			
			return e;		
		}
		

		
		/**
		 * 
		 * @return
		 */
		public boolean guardar (Estudiante e) {
			try {
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				if (e.getId() == 0) {
					em.persist(e);
				}
				else {
					em.merge(e);
				}
				em.getTransaction().commit();
				em.close();
				return true;
			}
			catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
		}
		
		
		/**
		 * 
		 */
		
		
		/**
		 * 
		 */
		public static List<Estudiante> findAllEstudiantes () {
			List<Estudiante> entities = new ArrayList<Estudiante>();
			EntityManager em = factory.createEntityManager();
			try {			
				Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
				entities = (List<Estudiante>) q.getResultList();
			}
			catch (NoResultException nrEx) {
			}
			em.close();
			return entities;
		}



		
		/**
		 * 
		 * @param id
		 * @return
		 */
		public void borrar(Estudiante p) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			p=em.merge(p);
			em.remove(p);
			em.getTransaction().commit();
			em.close();
	}
}
