package saniya.egenProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import saniya.egenProject.entity.MovieImdb;

@Repository
public class MovieImdbRepositoryImpl implements MovieImdbRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MovieImdb> fetchAll() {
		TypedQuery<MovieImdb> query = em.createNamedQuery("MovieImdb.findAll", MovieImdb.class);
		return query.getResultList();
	}

	@Override
	public MovieImdb fetchByTitle(String movietitle) {
		
		TypedQuery<MovieImdb> query = em.createNamedQuery("MovieImdb.findByTitle", MovieImdb.class);
		query.setParameter("pTitle", movietitle);
		List<MovieImdb> movies = query.getResultList();
		if(movies != null && movies.size() == 1)
		{
			return movies.get(0);
		}
		return null;
	}

	@Override
	public MovieImdb createNewImdbRating(MovieImdb m) {
		em.persist(m);
		return m;
	}

	@Override
	public MovieImdb updateImdbRating(String movietitle, MovieImdb m) {
		
		return em.merge(m);
	}

	@Override
	public void deleteImdbRating(String movietitle) {
		em.remove(movietitle);
		
	}

}
