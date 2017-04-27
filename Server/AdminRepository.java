package saniya.egenProject.repository;

import java.util.List;

import saniya.egenProject.entity.Admin;

public interface AdminRepository {
	
	public List<Admin> listAllAdmin();

	public Admin addAdmin(Admin m);
	
	public void deleteAdmin(String email);

}
