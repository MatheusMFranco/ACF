package br.com.alreadyhas.cf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alreadyhas.cf.util.ConfigurationUtil;

public abstract class GenericDAO<T> {

	private EntityManager entityManager = Persistence.createEntityManagerFactory(ConfigurationUtil.DATA_BASE).createEntityManager();

	private Class<T> className;

	public GenericDAO(Class<T> classe) {
      this.className = classe;
	}

	public void insert(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public T find(Integer id) {
		return entityManager.find(className, id);
	}

	public void delete(Integer id) {
		T entity = find(id);
		if (entity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		final StringBuilder sql = new StringBuilder("SELECT x FROM ");
		sql.append(className.getSimpleName()).append(" x");
		Query query = entityManager.createQuery(sql.toString());
		return query.getResultList();
	}

}