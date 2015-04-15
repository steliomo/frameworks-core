/*
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

import mz.co.mozview.frameworks.core.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public class StringNormalizer {

	public String normalize(final String text) throws BusinessException {

		if (text == null) {
			throw new BusinessException("The String must not be null");
		}

		return Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
				.matcher(Normalizer.normalize(text, Normalizer.Form.NFD)).replaceAll("");
	}
}
