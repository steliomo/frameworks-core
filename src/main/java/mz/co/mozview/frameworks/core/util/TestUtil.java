/**
 * 
 */
package mz.co.mozview.frameworks.core.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import mz.co.mozview.frameworks.core.model.GenericEntity;

/**
 * @author Stélio Moiane
 * 
 */
public class TestUtil {

	public static <T extends GenericEntity> void assertCreation(T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNull(entity.getUpdatedBy());
		assertNull(entity.getUpdatedAt());
		assertTrue(entity.isActive());
	}

	public static <T extends GenericEntity> void assertUpdate(T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNotNull(entity.getUpdatedBy());
		assertNotNull(entity.getUpdatedAt());
		assertTrue(entity.isActive());
	}
}
