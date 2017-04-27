package saniya.egenProject.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import saniya.egenProject.entity.UserActions;
import saniya.egenProject.exception.MovieNotFoundException;
import saniya.egenProject.exception.UserNotFoundException;

public class UserActionServiceImpl implements UserActionService {

	@Autowired
	UserActionRepository repository;
	
	@Override
	public UserActions fetchByMovieTitle(String movietitle) {
		
		UserActions existing = repository.getAll(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		return existing;
	}

	@Override
	public UserActions addNewUserAction(UserActions m) {
		
		return repository.addNewUserAction(m);
	}

	@Override
	public UserActions updateUserAction(String movietitle, UserActions m) {
		
		UserActions existing = repository.getAll(movietitle);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with title "+movietitle +"not found");
		}
		return repository.updateUserAction(m);
	
	}

	@Override
	public void deleteUserAction(String movietitle) {
		repository.deleteUserAction(movietitle);
		
	}

}
