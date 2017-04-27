package saniya.egenProject.services;

import java.util.List;
import saniya.egenProject.entity.UserActions;

public interface UserActionService {
	
	public UserActions fetchByMovieTitle(String movietitle);
	
	public UserActions addNewUserAction(UserActions m);
	
	public UserActions updateUserAction(String movietitle, UserActions m);
	
	public void deleteUserAction(String movietitle);
}
