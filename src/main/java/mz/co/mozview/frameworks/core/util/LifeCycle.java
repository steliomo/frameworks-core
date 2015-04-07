/**
 *
 */
package mz.co.mozview.frameworks.core.util;

/**
 * @author Stélio Moiane
 *
 */
public enum LifeCycle {

	ACTIVE(true), INACTIVE(false);

	private final boolean value;

	LifeCycle(final boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}
}
