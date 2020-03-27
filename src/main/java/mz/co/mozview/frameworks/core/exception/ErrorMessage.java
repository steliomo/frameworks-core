/*
 * Friends in Global Health - FGH © 2016
 */
package mz.co.mozview.frameworks.core.exception;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stélio Moiane
 *
 *         This pojo represents the error message object
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
