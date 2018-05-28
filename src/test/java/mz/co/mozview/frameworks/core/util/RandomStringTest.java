/**
 *
 */
package mz.co.mozview.frameworks.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class RandomStringTest {

	@Test
	public void shouldGenereteRandomString() {
		final int length = 10;

		final String generated = RandomStringFactory.generate(length);

		assertNotNull(generated);
		assertFalse(generated.isEmpty());
		assertEquals(length, generated.length());
	}
}
