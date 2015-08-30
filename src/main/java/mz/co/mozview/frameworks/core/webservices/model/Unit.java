/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.webservices.model;

import java.io.Serializable;

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
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String nuit;
	private String name;
	private String address;
	private String contact;

	public Unit(final String code, final String nuit, final String name, final String address, final String contact) {
		this.code = code;
		this.nuit = nuit;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	public Unit() {
	}

	public String getCode() {
		return this.code;
	}

	public String getNuit() {
		return this.nuit;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getContact() {
		return this.contact;
	}
}
