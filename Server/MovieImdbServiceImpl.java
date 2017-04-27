package saniya.egenProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import saniya.egenProject.entity.Movie;
import saniya.egenProject.entity.MovieImdb;
import saniya.egenProject.exception.MovieAlreadyExistsException;
import saniya.egenProject.exception.MovieNotFoundException;

public class MovieImdbServiceImpl implements MovieImdbService {

	@Autowired
	MovieImdbRepository repository;
	
	@Override
	public List<MovieImdb> fetchAll() {
		
		return repository.findAll();
	}

	@Override
	public MovieImdb fetchByTitle(String movietitle) {
	
		MovieImdb existing = repository.findByTitle(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		return existing;
	}

	@Override
	public MovieImdb createNewImdbRating(MovieImdb m) {
		
		MovieImdb existing = repository.findByTitle(m.getMovieTitle());
		if(existing != null) {
			throw new MovieAlreadyExistsException("Movie already exists "+m.getMovieTitle());
		}
		return repository.createNewImdbRating(m);
	}

	@Override
	public MovieImdb updateImdbRating(String movietitle, MovieImdb m) {
		
		MovieImdb existing = repository.findByTitle(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		return repository.updateImdbRating(m);
	}

	@Override
	public void deleteImdbRating(String movietitle) {
	
		MovieImdb existing = repository.findByTitle(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		repository.delete(existing);
	}

}
