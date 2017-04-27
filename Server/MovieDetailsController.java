package saniya.egenProject.controller;

import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.MovieDetails;
import saniya.egenProject.services.MovieDetailServices;

@RestController
@RequestMapping(path = "moviedetails")

public class MovieDetailsController {
	@Autowired
	MovieDetailService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDetails> listAllDetails()
	{
		return service.listAllDetails();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDetails addMovieDetails(@RequestBody MovieDetails m)
	{
		return service.addMovieDetails(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDetails updateMovieDetails(@PathVariable("movieTitle") String movietitle, @RequestBody MovieDetails m)
	{
		return service.updateMovieDetails(movietitle, m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{movieTitle}")
	public void deleteMovieDetails(@PathVariable("movieTitle") String movietitle)
	{
		service.deleteMovieDetails(movietitle);
	}


}
