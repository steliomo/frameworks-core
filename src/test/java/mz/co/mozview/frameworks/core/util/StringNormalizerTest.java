package mz.co.mozview.frameworks.core.util;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringNormalizerTest {

	private StringNormalizer stringNormalizer;

	@Before
	public void setup() {
		this.stringNormalizer = new StringNormalizer();
	}

	@Test
	public void shouldRemoveAccents() throws BusinessException {
		final String name = "Stélio Klésio Adriano Moiane";

		final String normalizedName = this.stringNormalizer.normalize(name);

		Assert.assertEquals("Stelio Klesio Adriano Moiane", normalizedName);
	}

	@Test(expected = BusinessException.class)
	public void shouldNotNormalizeNullText() throws BusinessException {

		this.stringNormalizer.normalize(null);
	}
}
