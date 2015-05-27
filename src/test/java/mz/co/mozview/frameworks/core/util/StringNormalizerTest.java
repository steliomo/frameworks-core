package mz.co.mozview.frameworks.core.util;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.junit.Assert;
import org.junit.Test;

public class StringNormalizerTest {

	@Test
	public void shouldRemoveAccents() throws BusinessException {
		final String name = "Stélio Klésio Adriano Moiane";

		final String normalizedName = StringNormalizer.normalize(name);

		Assert.assertEquals("Stelio Klesio Adriano Moiane", normalizedName);
	}

	@Test(expected = BusinessException.class)
	public void shouldNotNormalizeNullText() throws BusinessException {

		StringNormalizer.normalize(null);
	}

	@Test
	public void shouldNormalizeAndUpperCase() throws BusinessException {
		final String name = "Stélio Klésio Adriano Moiane";

		final String normalizedName = StringNormalizer.normalizeAndUppCase(name);

		Assert.assertEquals("STELIO KLESIO ADRIANO MOIANE", normalizedName);

	}
}
