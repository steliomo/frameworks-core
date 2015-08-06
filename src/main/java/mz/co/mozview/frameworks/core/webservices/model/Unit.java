/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stélio Moiane
 *
 *         Este objecto representa a unidade de serviço. Seja ele uma farmácia,
 *         um salão de beleza, o que for.
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

	private String code;
	private String name;

	public Unit(final String code, final String name) {
		this.code = code;
		this.name = name;
	}

	public Unit() {
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}
}
