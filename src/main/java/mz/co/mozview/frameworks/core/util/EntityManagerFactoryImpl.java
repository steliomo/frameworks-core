/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * @author Stélio Moiane
 *
 */
@Service(EntityManagerFactory.NAME)
public class EntityManagerFactoryImpl implements EntityManagerFactory {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void deleteFrom(final String tableName) {
		this.entityManager.createQuery("delete from " + tableName).executeUpdate();
	}
}
