package saniya.egenProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saniya.egenProject.entity.Movie;
import saniya.egenProject.exception.MovieAlreadyExistsException;
import saniya.egenProject.exception.MovieNotFoundException;
import saniya.egenProject.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Movie findOne(String title) {
		Movie existing = repository.findOne(title);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+title +"not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie createMovie(Movie m) {
		Movie existing = repository.findByTitle(m.getMovieTitle());
		if(existing != null) {
			throw new MovieAlreadyExistsException("Movie already exists "+m.getMovieTitle());
		}
		return repository.createMovie(m);
	}

	@Override
	@Transactional
	public Movie updateMovie(String title, Movie m) {
		Movie existing = repository.findOne(title);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+title +"not found");
		}
		return repository.updateMovie(m);
	}

	@Override
	@Transactional
	public void delete(String title) {
		Movie existing = repository.findOne(title);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+title +"not found");
		}
		repository.delete(existing);
	}

}
