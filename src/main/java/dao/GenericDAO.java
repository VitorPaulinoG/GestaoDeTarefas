package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpautil.JPAUtil;

public class GenericDAO<T> {
	
	private EntityManager entityManager = JPAUtil.getEntityManager();
	
	public void salvar (T entidade)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(entidade);
		transaction.commit();
		entityManager.close();
	}
	public T buscar (T entidade)
	{
		Object id = JPAUtil.getPrimaryKey(entidade);
		T ent = (T) entityManager.find(entidade.getClass(), id);
		return ent;
	}
	
	public List<T> listar (Class<T> entidade)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<T> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		transaction.commit();
		return lista;
		
	}
}
