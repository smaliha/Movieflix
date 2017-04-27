package saniya.egenProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.Users;
import saniya.egenProject.services.UserService;

@RestController
@RequestMapping(path = "users")

public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Users> getAll()
	{
		return service.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users getOne(@PathVariable("users.email") String email)
	{
		return service.getOne(email);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users addUsers(@RequestBody Users m)
	{
		return service.addUsers(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users updateUsers(@PathVariable("Useremail") String email, @RequestBody Users m)
	{
		return service.updateUsers(email, m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{email}")
	public void deleteUser(@PathVariable("Useremail") String email)
	{
		service.deleteUser(email);
	}

}
