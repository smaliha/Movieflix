package saniya.egenProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saniya.egenProject.entity.Admin;
import saniya.egenProject.services.AdminService;

@RestController
@RequestMapping(path = "admin")

public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Admin> listAllAdmin()
	{
		return service.listAllAdmin();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Admin addAdmin(@RequestBody Admin m)
	{
		return service.addAdmin(m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{email}")
	public void deleteAdmin(@PathVariable("AdminEmail") String email)
	{
		service.deleteAdmin(email);
	}

}
