package saniya.egenProject.services;

import java.util.List;
import saniya.egenProject.entity.Users;

public interface UserService {
	
	public List<Users> getAll();
	
	public Users getOne(String email);
	
	public Users addUsers(Users m);
	
	public Users updateUsers(String email, Users m);
	
	public void deleteUser(String email);
}
