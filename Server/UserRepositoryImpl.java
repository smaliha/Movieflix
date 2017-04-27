package saniya.egenProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import saniya.egenProject.entity.Users;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Users> getAll() {

		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users getOne(String email) {
		
		return em.find(Users.class, email);
	}

	@Override
	public Users addUsers(Users m) {
		
		em.persist(m);
		return m;
	}

	@Override
	public Users updateUsers(String email, Users m) {
		
		return em.merge(m);
	}

	@Override
	public void deleteUser(String email) {
		em.remove(email);
		
	}

}
