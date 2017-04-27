package saniya.egenProject.services;

import java.util.List;
import saniya.egenProject.entity.Admin;

public interface AdminService {

	public List<Admin> listAllAdmin();

	public Admin addAdmin(Admin m);
	
	public void deleteAdmin(String email);

}
