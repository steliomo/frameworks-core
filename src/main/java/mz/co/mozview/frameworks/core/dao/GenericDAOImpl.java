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
import javax.persistence.TypedQuery;

import mz.co.mozview.frameworks.core.exception.DataBaseException;
import mz.co.mozview.frameworks.core.model.GenericEntity;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Stelio Moiane
 *
 * @param <T>
 */
public abstract class GenericDAOImpl<T extends GenericEntity, V extends Serializable> implements GenericDAO<T, V> {

	private final Class<T> clazz;

	@PersistenceContext
	private EntityManager entityManager;

	public GenericDAOImpl(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T findById(final Long id) {
		return this.getEntityManager().find(this.clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.getEntityManager().createQuery("from " + this.clazz.getName()).getResultList();
	}

	@Override
	public T create(final Long userContextId, final T entity) {

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

	@Override
	public T update(final Long userContextId, final T entity) {

		entity.setUpdatedBy(userContextId);
		entity.setUpdatedAt(Calendar.getInstance());

		try {
			return this.getEntityManager().merge(entity);
		} catch (final PersistenceException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	@Override
	public void delete(final Long userContextId, final T entity) {
		this.getEntityManager().remove(
				this.getEntityManager().contains(entity) ? entity : this.update(userContextId, entity));
	}

	@Override
	public void deleteById(final Long userContextId, final Long entityId) {
		final T entity = this.findById(entityId);
		this.delete(userContextId, entity);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params) {

		final Query query = this.getEntityManager().createNamedQuery(queryName);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findSingleByNamedQuery(final String name, final Map<String, ? extends Object> params) {

		final Query query = this.getEntityManager().createNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return (T) query.getSingleResult();
	}

	@Override
	public Query findByQuery(final String name, final Map<String, ? extends Object> params) {
		final Query query = this.getEntityManager().createNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query;
	}

	@Override
	public <Y> List<Y> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
			final Class<Y> clazz) {

		final TypedQuery<Y> query = this.getEntityManager().createNamedQuery(queryName, clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@Override
	public <Y> Y findSingleByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
			final Class<Y> clazz) {

		final TypedQuery<Y> query = this.getEntityManager().createNamedQuery(queryName, clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getSingleResult();
	}

	@Override
	public Long count() {
		return this.getEntityManager().createQuery("select count(id) from " + this.clazz.getName(), Long.class)
				.getSingleResult();
	}

	@Override
	public String generateCode(final String prefix, final int codeLength, final String completeValue) {
		Long sequence = this.count();
		String code = prefix;
		code += StringUtils.leftPad("" + (++sequence), codeLength, completeValue);

		return code;
	}
}
