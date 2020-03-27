/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.service.util;

/**
 * @author Stélio Moiane
 *
 */
public enum StatusCode {

	OK(200), NO_CONTENT(204);

	private final int code;

	private StatusCode(final int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
