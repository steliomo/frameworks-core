/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.adapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stélio Moiane
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

	public static final String UUID = "uuid";

	public static final String RESET = "reset";

	private String uuid;

	private boolean reset;

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public boolean isReset() {
		return this.reset;
	}

	public void setReset(final boolean reset) {
		this.reset = reset;
	}
}
