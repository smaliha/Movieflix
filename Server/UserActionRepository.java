package saniya.egenProject.repository;

import saniya.egenProject.entity.UserActions;

public interface UserActionRepository {
	
	public UserActions fetchByMovieTitle(String movietitle);
	
	public UserActions addNewUserAction(UserActions m);
	
	public UserActions updateUserAction(String movietitle, UserActions m);
	
	public void deleteUserAction(String movietitle);
}
