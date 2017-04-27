package saniya.egenProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.Movie;
import saniya.egenProject.services.MovieService;

@RestController
@RequestMapping(path = "movies")

public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll()
	{
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("movieTitle") String movietitle)
	{
		return service.findOne(movietitle);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createNewMovie(@RequestBody Movie m)
	{
		return service.createMovie(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie updateMovie(@PathVariable("movieTitle") String movietitle, @RequestBody Movie m)
	{
		return service.updateMovie(movietitle, m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{movieTitle}")
	public void deleteMovie(@PathVariable("movieTitle") String movietitle)
	{
		service.delete(movietitle);
	}
}
