/**
 *
 */
package mz.co.mozview.frameworks.core.fixtureFactory.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import mz.co.mozview.frameworks.core.model.GenericEntity;
import mz.co.mozview.frameworks.core.util.LifeCycleStatus;

/**
 * @author Stélio Moiane
 *
 */
public class TestUtil {

	public static <T extends GenericEntity> void assertCreation(final T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNull(entity.getUpdatedBy());
		assertNull(entity.getUpdatedAt());
		assertEquals(LifeCycleStatus.ACTIVE, entity.getLifeCycleStatus());
	}

	public static <T extends GenericEntity> void assertUpdate(final T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNotNull(entity.getUpdatedBy());
		assertNotNull(entity.getUpdatedAt());
		assertEquals(LifeCycleStatus.ACTIVE, entity.getLifeCycleStatus());
	}
}
