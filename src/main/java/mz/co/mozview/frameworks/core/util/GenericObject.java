/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import java.util.HashMap;

/**
 * Este Utilitário é usado para armazenar dados de qualquer tipo
 *
 * @author Stélio Moiane
 *
 */
public class GenericObject {

	private final HashMap<String, Object> data;

	public GenericObject() {
		this.data = new HashMap<>();
	}

	public void putValue(final String key, final Object value) {
		this.data.put(key, value);
	}

	public Object getValue(final String key) {
		return this.data.get(key);
	}
}
