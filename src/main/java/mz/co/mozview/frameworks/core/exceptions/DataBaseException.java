/**
 * 
 */
package mz.co.mozview.frameworks.core.exceptions;

import javax.persistence.PersistenceException;

/**
 * Exception de erros de base de dados
 * 
 * @author Stélio Moiane
 */
public class DataBaseException extends PersistenceException {
	private static final long serialVersionUID = 1L;

	public DataBaseException() {
	}

	public DataBaseException(final String message) {
		super(message);
	}
}
