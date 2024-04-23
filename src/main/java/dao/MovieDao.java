package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import dto.Moviedto;

public class MovieDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("deepika");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	private String name;

	public void saveMovie(Moviedto movie) {
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
	
	public List<MovieDao> fetchMoviesByRating(double rating){
		return  manager.createQuery("Select x from Moviedto x Where rating=?1").setParameter(1,rating).getResultList();
		
	}
	public List<MovieDao> fetchMoviesById(int id) {
		return  manager.createQuery("Select x from Moviedto x Where id=?1").setParameter(1,id).getResultList();
	}
	public List<MovieDao> FetchMovieByGenre(String genre) {
		return  manager.createQuery("Select x from Moviedto x Where genre=?1").setParameter(1,genre).getResultList();
	}
	public List<MovieDao> FetchMovieByLanguage(String language) {
		return  manager.createQuery("Select x from Moviedto x Where language=?1").setParameter(1,language).getResultList();
	}
	public List<MovieDao> FetchMovieByName(String name) {
		return  manager.createQuery("Select x from Moviedto x Where name=?1").setParameter(1,name).getResultList();
	}
	public List<MovieDao> FetchAllMovie() {
		return  manager.createQuery("Select x from Moviedto x").getResultList();
	}

	public void deleteMovie(int id) {
		transaction.begin();
		manager.remove(manager.find(Moviedto.class, id));
		transaction.commit();
		
	}

	public Moviedto findMovie(int id) {
		return manager.find(Moviedto.class, id);
	}

	public void updateMovie(Moviedto movie) {
		transaction.begin();
		manager.merge(movie);
		transaction.commit();
	}


	
	}


		
	

