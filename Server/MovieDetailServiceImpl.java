package saniya.egenProject.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saniya.egenProject.entity.Movie;
import saniya.egenProject.entity.MovieDetails;
import saniya.egenProject.exception.MovieNotFoundException;

@Service
public class MovieDetailServiceImpl implements MovieDetailService {

	@Autowired
	MovieDetailRepository repository;
	
	@Override
	public List<MovieDetails> listMovieDetails() {
		
		return repository.listMovieDetails();
	}

	@Override
	@Transactional
	public MovieDetails addMovieDetails(MovieDetails m) {
		
		return repository.addMovieDetails(m);
	}

	@Override
	@Transactional
	public MovieDetails updateMovieDetails(String movietitle, MovieDetails m) {
		
		MovieDetails existing = repository.findByTitle(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		return repository.updateMovieDetails(m);
	}

	@Override
	@Transactional
	public void deleteMovieDetails(String movietitle) {
		MovieDetails existing = repository.findByTitle(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		repository.delete(existing);		
	}

}
