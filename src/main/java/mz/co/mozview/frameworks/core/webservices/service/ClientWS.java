/**
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.webservices.service;

import com.sun.jersey.api.client.WebResource;

/**
 * @author Stélio Moiane
 *
 */
public interface ClientWS {

	String NAME = "mz.co.mozview.frameworks.core.webservices.service.ClientWS";

	public void setResourceUrl(final String url);

	public WebResource getWebResource();

	public Object getXmlValue(final String url, final Class<?> clazz);

	public Object getJsonValue(final String url, final Class<?> clazz);

	public WebResource postXML(final String url, final Object object);

	public WebResource postJSON(final String url, final Object object);

	public WebResource putXML(final String url, final Object object);

	public WebResource putJSON(final String url, final Object object);

	public WebResource deleteXML(final String url, final Object object);

	public WebResource deleteJSON(final String url, final Object object);
}
