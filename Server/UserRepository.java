package saniya.egenProject.repository;

import java.util.List;

import saniya.egenProject.entity.Users;

public interface UserRepository {
	public List<Users> getAll();
	
	public Users getOne(String email);
	
	public Users addUsers(Users m);
	
	public Users updateUsers(String email, Users m);
	
	public void deleteUser(String email);
}
