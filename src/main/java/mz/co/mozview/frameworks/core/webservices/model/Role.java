/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Stélio Moiane
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;

	public Role(final String name, final String description) {
		this.name = name;
		this.description = description;
	}

	public Role() {
	}

	@Override
	public String getAuthority() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}
