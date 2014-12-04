/**
 *
 */
package mz.co.mozview.frameworks.core.webservices;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Stélio Moiane
 *
 */
@Component
public class ClientWS {
	private final Client client;
	private WebResource webResource;

	public ClientWS() {
		this.client = Client.create();
	}

	public void resource(final String url) {
		this.webResource = this.client.resource(url);
	}

	public Object getXmlValue(final Class<?> clazz) {
		return this.webResource.accept("application/xml")
				.type("application/xml").get(clazz);
	}

	public Object getJsonValue(final Class<?> clazz) {
		return this.webResource.accept("application/json")
				.type("application/json").get(clazz);
	}

	public WebResource getResource() {
		return this.webResource;
	}
}
