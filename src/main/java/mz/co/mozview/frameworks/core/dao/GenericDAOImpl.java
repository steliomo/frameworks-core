/**
 *
 */
package mz.co.mozview.frameworks.core.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mz.co.mozview.frameworks.core.exception.DataBaseException;
import mz.co.mozview.frameworks.core.model.GenericEntity;

/**
 * @author Stelio Moiane
 *
 * @param <T>
 */
public class GenericDAOImpl<T, V extends Serializable> implements
GenericDAO<T, V> {

	private final Class<T> clazz;

	@PersistenceContext
	private EntityManager entityManager;

	public GenericDAOImpl(final Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public T getById(final Long id) {
		return this.getEntityManager().find(this.clazz, id);
	}

	/**
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.getEntityManager()
				.createQuery("from " + this.clazz.getName()).getResultList();
	}

	/**
	 * @param entity
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T extends GenericEntity> T create(final Long userContextId,
			final T entity) {

		entity.setActive(true);
		entity.setCreatedBy(userContextId);
		entity.setCreatedAt(Calendar.getInstance());

		try {

			this.getEntityManager().persist(entity);

		} catch (final PersistenceException e) {
			throw new DataBaseException(e.getMessage());
		}

		return entity;
	}

	/**
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T extends GenericEntity> T update(final Long userContextId,
			final T entity) {

		entity.setUpdatedBy(userContextId);
		entity.setUpdatedAt(Calendar.getInstance());

		try {
			return this.getEntityManager().merge(entity);
		} catch (final PersistenceException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	/**
	 * @param entity
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T extends GenericEntity> void delete(final Long userContextId,
			final T entity) {
		this.getEntityManager().remove(
				this.getEntityManager().contains(entity) ? entity : this
						.update(userContextId, entity));
	}

	/**
	 * @param entityId
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T extends GenericEntity> void deleteById(final Long userContextId,
			final Long entityId) {
		final T entity = (T) this.getById(entityId);
		this.delete(userContextId, entity);
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @param queryName
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(final String queryName,
			final Map<String, ? extends Object> params) {

		final Query query = this.getEntityManager().createNamedQuery(queryName);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findSingleByNamedQuery(final String name,
			final Map<String, ? extends Object> params) {

		final Query query = this.getEntityManager().createNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return (T) query.getSingleResult();
	}

	@Override
	public Query findByQuery(final String name,
			final Map<String, ? extends Object> params) {
		final Query query = this.getEntityManager().createNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query;
	}
}
