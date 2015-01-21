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

	String NAME = "mz_co_mozview_frameworks_core_webservices_service_ClientWS";

	public void setResourceUrl(final String url);

	public WebResource getWebResource();

	public Object getXmlValue(final String url, final Class<?> clazz);

	public Object getJsonValue(final String url, final Class<?> clazz);

	public void post(final String url, final Object object);

	public void put(final String url, final Object object);

	public void delete(final String url, final Object object);
}
