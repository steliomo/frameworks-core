/*
 * MozView Technologies, Lda. 2010 - 2015
 */

package mz.co.mozview.frameworks.core.util;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.inject.Inject;

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

	@Inject
	private EntityManagerFactory entityManager;

	public static Deque<String> entitiesCreated = new ArrayDeque<>();

	private final static Logger logger = Logger.getLogger(CleanDBUtil.class);

	public CleanDBUtil() {
	}

	public CleanDBUtil(final EntityManagerFactory entityManager) {
		this.entityManager = entityManager;
	}

	public void cleanDB() {
		while (!entitiesCreated.isEmpty()) {
			final String tableName = entitiesCreated.pop();
			this.entityManager.deleteFrom(tableName);

			logger.info("Todos os dados da tabela " + tableName + " foram removidos com sucesso!");
		}
	}

	public static void pushEntity(final String entityName) {
		if (!entitiesCreated.contains(entityName)) {
			entitiesCreated.push(entityName);

			logger.info("A tabela " + entityName + " foi inserida na pilha!");
		}
	}
}
