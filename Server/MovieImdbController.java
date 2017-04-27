package saniya.egenProject.controller;

import java.util.List;
import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.MovieImdb;
import saniya.egenProject.services.MovieImdbService;

@RestController
@RequestMapping(path = "movieImdb")

public class MovieImdbController {

	@Autowired
	MovieImdbService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieImdb> fetchAll()
	{
		return service.fetchAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieImdb fetchByTitle(@PathVariable("movieTitle") String movietitle)
	{
		return service.fetchByTitle(movietitle);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieImdb createNewRating(@RequestBody MovieImdb m)
	{
		return service.createNewImdbRating(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieImdb updateImdbRating(@PathVariable("movieTitle") String movietitle, @RequestBody MovieImdb m)
	{
		return service.updateImdbRating(movietitle, m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{movieTitle}")
	public void deleteImdbRating(@PathVariable("movieTitle") String movietitle)
	{
		service.deleteImdbRating(movietitle);
	}

}
