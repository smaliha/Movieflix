package saniya.egenProject.services;

import java.util.List;
import saniya.egenProject.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();
	
	public Movie findOne(String title);
	
	public Movie createMovie(Movie m);
	
	public Movie updateMovie(String title, Movie m);
	
	public void delete(String title);

}
