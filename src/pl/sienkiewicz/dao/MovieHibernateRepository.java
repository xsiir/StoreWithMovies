package pl.sienkiewicz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pl.sienkiewicz.api.MovieRepository;
import pl.sienkiewicz.dto.MovieDTO;

@Repository
public class MovieHibernateRepository implements MovieRepository {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracleTest");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public List<MovieDTO> getMovies() {
		String query = "SELECT m FROM MOVIES m";
		TypedQuery<MovieDTO> x = entityManager.createQuery(query, MovieDTO.class);
		return x.getResultList();
	}

	@Override
	public List<MovieDTO> getMoviesByCategory(String category) {
		if (category.equalsIgnoreCase("ANY")) {
			return getMovies();
		} else {
			String query = "SELECT m FROM MOVIES m WHERE category = '" + category + "'";
			TypedQuery<MovieDTO> x = entityManager.createQuery(query, MovieDTO.class);
			return x.getResultList();
		}
	}

	@Override
	public MovieDTO getMovieById(Integer id) {
		TypedQuery<MovieDTO> query = entityManager.createQuery("SELECT movie FROM MOVIES movie WHERE id = " + id,
				MovieDTO.class);
		return query.getSingleResult();
	}

}