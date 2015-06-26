/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.webservices.model;

/**
 * @author Stélio Moiane
 *
 *         Este objecto representa a unidade de serviço. Seja ele uma farmácia,
 *         um salão de beleza, o que for.
 *
 */
public class Unit {

	private final String code;
	private final String name;

	public Unit(final String code, final String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}
}
