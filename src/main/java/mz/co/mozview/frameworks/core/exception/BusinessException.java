/**
 * 
 */
package mz.co.mozview.frameworks.core.exception;

/**
 * @author Stélio Moiane
 * 
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

}
