/**
 *
 */
package mz.co.mozview.frameworks.core.util;

import java.util.Random;

/**
 * @author Stélio Moiane
 *
 */
public class RandomStringFactory {

	private static final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public static String generate(final int lenth) {

		final StringBuilder salt = new StringBuilder();
		final Random random = new Random();

		while (salt.length() < lenth) {
			final int index = (int) (random.nextFloat() * SALT_CHARS.length());
			salt.append(SALT_CHARS.charAt(index));
		}

		return salt.toString();
	}
}
