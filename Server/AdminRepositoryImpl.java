package saniya.egenProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import saniya.egenProject.entity.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Admin> listAllAdmin() {
		TypedQuery<Admin> query = em.createNamedQuery("Admin.listAllAdmin", Admin.class);
		return query.getResultList();
	}

	@Override
	public Admin addAdmin(Admin m) {
		
		em.persist(m);
		return m;
	}

	@Override
	public void deleteAdmin(String email) {
		em.remove(email);
		
	}

}
