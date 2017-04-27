package saniya.egenProject.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import saniya.egenProject.entity.Movie;
import saniya.egenProject.entity.MovieDetails;

@Repository
public class MovieDetailRepositoryImpl implements MovieDetailRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MovieDetails> listMovieDetails() {
		
		TypedQuery<MovieDetails> query = em.createNamedQuery("MovieDetails.findAll", MovieDetails.class);
		return query.getResultList();
	}

	@Override
	public MovieDetails addMovieDetails(MovieDetails m) {
		em.persist(m);
		return m;
	}

	@Override
	public MovieDetails updateMovieDetails(String movietitle, MovieDetails m) {
		
		return em.merge(m);
	}

	@Override
	public void deleteMovieDetails(String movietitle) {
		em.remove(movietitle);
		
	}

}
