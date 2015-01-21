/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.service;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Stélio Moiane
 *
 */
@Service(ClientWS.NAME)
public class ClientWSImpl implements ClientWS {
	private final Client client;
	private WebResource webResource;

	public ClientWSImpl() {
		this.client = Client.create();
	}

	@Override
	public void setResourceUrl(final String url) {
		this.webResource = this.client.resource(url);
	}

	@Override
	public WebResource getWebResource() {
		return this.webResource;
	}

	@Override
	public Object getXmlValue(final String url, final Class<?> clazz) {
		this.webResource = this.client.resource(url);
		return this.webResource.accept("application/xml").type("application/xml").get(clazz);
	}

	@Override
	public Object getJsonValue(final String url, final Class<?> clazz) {
		this.webResource = this.client.resource(url);
		return this.webResource.accept("application/json").type("application/json").get(clazz);
	}

	@Override
	public void post(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.post(object);
	}

	@Override
	public void put(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.put(object);
	}

	@Override
	public void delete(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.delete(object);
	}
}
