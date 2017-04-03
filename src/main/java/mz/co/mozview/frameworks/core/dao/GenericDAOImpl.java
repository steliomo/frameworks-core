/**
 *
 */
package mz.co.mozview.frameworks.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import mz.co.mozview.frameworks.core.exception.DataBaseException;
import mz.co.mozview.frameworks.core.model.GenericEntity;
import mz.co.mozview.frameworks.core.util.LifeCycleStatus;
import mz.co.mozview.frameworks.core.util.UuidFactory;

/**
 * @author Stelio Moiane
 *
 * @param <T>
 */
public abstract class GenericDAOImpl<T extends GenericEntity, V extends Serializable> implements GenericDAO<T, V> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> clazz;

	public GenericDAOImpl() {
		this.clazz = this.getSuperClass();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getSuperClass() {
		final ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public T findById(final Long id) {
		return this.getEntityManager().find(this.clazz, id);
	}

	@Override
	public T create(final Long userContextId, final T entity) {

		entity.setLifeCycleStatus(LifeCycleStatus.ACTIVE);
		entity.setCreatedBy(userContextId);
		entity.setCreatedAt(Calendar.getInstance());
		entity.setUuid(UuidFactory.generate());

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
		final T foundEntity = this.findById(entity.getId());

		if (foundEntity != null) {
			this.getEntityManager().remove(foundEntity);
		}
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
