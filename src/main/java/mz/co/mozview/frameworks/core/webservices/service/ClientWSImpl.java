/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.service;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author Stélio Moiane
 *
 */
@Service(ClientWS.NAME)
public class ClientWSImpl implements ClientWS {
	private final Client client;
	private WebResource webResource;

	public ClientWSImpl() {
		final DefaultClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		this.client = Client.create(config);
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
		return this.webResource.accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).get(clazz);
	}

	@Override
	public Object getJsonValue(final String url, final Class<?> clazz) {
		this.webResource = this.client.resource(url);
		return this.webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(clazz);
	}

	@Override
	public WebResource postXML(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(object);
		return this.webResource;
	}

	@Override
	public WebResource postJSON(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(object);
		return this.webResource;
	}

	@Override
	public WebResource putXML(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).put(object);
		return this.webResource;
	}

	@Override
	public WebResource putJSON(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(object);
		return this.webResource;
	}

	@Override
	public WebResource deleteXML(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).delete(object);
		return this.webResource;
	}

	@Override
	public WebResource deleteJSON(final String url, final Object object) {
		this.webResource = this.client.resource(url);
		this.webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).delete(object);
		return this.webResource;
	}
}
