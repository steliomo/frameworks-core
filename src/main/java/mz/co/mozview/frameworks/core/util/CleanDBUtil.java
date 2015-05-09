/*
 * MozView Technologies, Lda. 2010 - 2015
 */

package mz.co.mozview.frameworks.core.util;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Stélio Moiane
 *
 */
@Component
@Transactional
public class CleanDBUtil {

	@PersistenceContext
	private EntityManager entityManager;

	public static Deque<String> entitiesCreated = new ArrayDeque<>();

	private final static Logger logger = Logger.getLogger(CleanDBUtil.class);

	public void cleanDB() {
		while (!entitiesCreated.isEmpty()) {
			final String pop = entitiesCreated.pop();
			this.entityManager.createQuery("delete from " + pop).executeUpdate();

			logger.info("Todos os dados da tabela " + pop + " foram removidos com sucesso!");
		}
	}

	public static void pushEntity(final String entityName) {
		if (!entitiesCreated.contains(entityName)) {
			entitiesCreated.push(entityName);

			logger.info("A tabela " + entityName + " foi inserida na pilha!");
		}
	}
}
