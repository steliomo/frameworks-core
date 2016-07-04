/**
 *
 */
package mz.co.mozview.frameworks.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import mz.co.mozview.frameworks.core.model.GenericEntity;

/**
 * @author Stélio Klésio Adriano Moiane
 *
 */
public interface GenericDAO<T extends GenericEntity, V extends Serializable> {

	public T findById(final Long id);

	public T create(final Long userContextId, final T entity);

	public T update(final Long userContextId, final T entity);

	public void delete(final Long userContextId, final T entity);

	public List<T> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params);

	public T findSingleByNamedQuery(final String name, final Map<String, ? extends Object> params);

	public Query findByQuery(final String name, final Map<String, ? extends Object> params);

	public <Y> List<Y> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
			final Class<Y> clazz);

	public <Y> Y findSingleByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
			final Class<Y> clazz);

	public Long count();

	public String generateCode(String prefix, int codeLength, String completeValue);
}
