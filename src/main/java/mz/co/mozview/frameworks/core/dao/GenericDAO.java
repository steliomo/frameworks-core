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
public interface GenericDAO<T, V extends Serializable> {

	/**
	 * @param id
	 * @return
	 */
	public T getById(final Long id);

	/**
	 * @return
	 */
	public List<T> getAll();

	/**
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T extends GenericEntity> T create(final Long userContextId,
			final T entity);

	/**
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T extends GenericEntity> T update(final Long userContextId,
			final T entity);

	/**
	 * @param entity
	 */
	@SuppressWarnings("hiding")
	public <T extends GenericEntity> void delete(final Long userContextId,
			final T entity);

	/**
	 * @param entityId
	 */
	@SuppressWarnings("hiding")
	public <T extends GenericEntity> void deleteById(final Long userContextId,
			final Long entityId);

	/**
	 * @param queryName
	 * @param params
	 * @return
	 */
	public List<T> findByNamedQuery(final String queryName,
			final Map<String, ? extends Object> params);

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	public T findSingleByNamedQuery(final String name,
			final Map<String, ? extends Object> params);

	public Query findByQuery(final String name,
			final Map<String, ? extends Object> params);
}
