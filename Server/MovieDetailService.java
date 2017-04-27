package saniya.egenProject.services;
import java.util.List;
import saniya.egenProject.entity.MovieDetails;

public interface MovieDetailService {

	public List<MovieDetails> listMovieDetails();
	
	public MovieDetails addMovieDetails(MovieDetails m);
	
	public MovieDetails updateMovieDetails(String movietitle, MovieDetails m);
	
	public void deleteMovieDetails(String movietitle);
	
}
