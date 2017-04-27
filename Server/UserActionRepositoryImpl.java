package saniya.egenProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import saniya.egenProject.entity.Movie;
import saniya.egenProject.entity.UserActions;

@Repository
public class UserActionRepositoryImpl implements UserActionRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserActions fetchByMovieTitle(String movietitle) {
		
		TypedQuery<UserActions> query = em.createNamedQuery("UserActions.getAll", UserActions.class);
		query.setParameter("pTitle", movietitle);
		List<UserActions> useractions = query.getResultList();
		if(useractions != null && useractions.size() == 1)
		{
			return useractions.get(0);
		}
		return null;
	}

	@Override
	public UserActions addNewUserAction(UserActions m) {
		
		em.persist(m);
		return m;
	}

	@Override
	public UserActions updateUserAction(String movietitle, UserActions m) {
		
		return em.merge(m);
	}

	@Override
	public void deleteUserAction(String movietitle) {
		em.remove(movietitle);
		
	}

}
