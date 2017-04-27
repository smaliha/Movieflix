package saniya.egenProject.repository;

import java.util.List;

import saniya.egenProject.entity.Movie;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
		
	}

	@Override
	public Movie findOne(String title) {
		
		return em.find(Movie.class, title);
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if(movies != null && movies.size() == 1)
		{
			return movies.get(0);
		}
		return null;
	}
	@Override
	public Movie createMovie(Movie m) {
		em.persist(m);
		return m;
	}

	@Override
	public Movie updateMovie(Movie m) {
		
		return em.merge(m);
	}

	@Override
	public void delete(Movie m) {
		em.remove(m);
	}

}
