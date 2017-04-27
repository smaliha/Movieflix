package saniya.egenProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import saniya.egenProject.entity.Movie;
import saniya.egenProject.entity.Users;
import saniya.egenProject.exception.MovieAlreadyExistsException;
import saniya.egenProject.exception.MovieNotFoundException;
import saniya.egenProject.exception.UserAlreadyExistsException;
import saniya.egenProject.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<Users> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Users getOne(String email) {
		Users existing = repository.findByEmail(email);
		if(existing == null) {
			throw new UserNotFoundException("User with email "+email +"not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Users addUsers(Users m) {
		Users existing = repository.findByEmail(m.getEmail());
		if(existing != null) {
			throw new UserAlreadyExistsException("User already exists "+m.getEmail());
		}
		return repository.addUsers(m);
	
		return null;
	}

	@Override
	@Transactional
	public Users updateUsers(String email, Users m) {
		
		Users existing = repository.findByEmail(email);
		if(existing == null) {
			throw new UserNotFoundException("User with email "+email +"not found");
		}
		return repository.updateUsers(m);
	}

	@Override
	@Transactional
	public void deleteUser(String email) {
		Users existing = repository.findByEmail(email);
		if(existing == null) {
			throw new UserNotFoundException("User with email "+email +"not found");
		}
		repository.deleteUser(existing);
	
		
	}

}
