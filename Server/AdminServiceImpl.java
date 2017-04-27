package saniya.egenProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import saniya.egenProject.entity.Admin;
import saniya.egenProject.exception.AdminAlreadyExistsException;
import saniya.egenProject.exception.AdminNotFoundException;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repository;
	
	@Override
	public List<Admin> listAllAdmin() {
		
		return repository.listAllAdmin();
	}

	@Override
	public Admin addAdmin(Admin m) {
		
		Admin existing = repository.findByEmail(m.getEmail());
		if(existing != null) {
			throw new AdminAlreadyExistsException("Admin already exists "+m.getEmail());
		}
		return repository.addAdmin(m);

	}

	@Override
	public void deleteAdmin(String email) {
		
		Admin existing = repository.findByEmail(email);
		if(existing == null) {
			throw new AdminNotFoundException("Admin with email "+email +"not found");
		}
		repository.delete(existing);
	
	}

}
