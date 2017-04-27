package saniya.egenProject.repository;

import java.util.List;
import saniya.egenProject.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	
	public Movie findOne(String title);
	
	public Movie findByTitle(String title);
	
	public Movie createMovie(Movie m);
	
	public Movie updateMovie(Movie m);
	
	public void delete(Movie m);

}
