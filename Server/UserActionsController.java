package saniya.egenProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.UserActions;
import saniya.egenProject.services.UserActionService;

@RestController
@RequestMapping(path = "useractions")

public class UserActionsController {
	@Autowired
	UserActionService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserActions> fetchAll()
	{
		return service.fetchAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserActions fetchByMovieTitle(@PathVariable("movieTitle") String movietitle)
	{
		return service.fetchByMovieTitle(movietitle);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserActions addNewUserAction(@RequestBody UserActions m)
	{
		return service.addNewUserAction(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{movieTitle}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserActions updateUserAction(@PathVariable("movieTitle") String movietitle, @RequestBody UserActions m)
	{
		return service.updateUserAction(movietitle, m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{movieTitle}")
	public void deleteUserAction(@PathVariable("movieTitle") String movietitle)
	{
		service.deleteUserAction(movietitle);
	}
}
