/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.adapter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Stélio Moiane
 *
 */
public class MapAdapter extends XmlAdapter<Entry, Map<String, Object>> {

	@Override
	public Map<String, Object> unmarshal(final Entry entry) throws Exception {
		final Map<String, Object> map = new HashMap<>();

		if (entry == null) {
			return map;
		}

		map.put(Entry.UUID, entry.getUuid());
		return map;
	}

	@Override
	public Entry marshal(final Map<String, Object> map) throws Exception {
		final Entry entry = new Entry();

		if (map == null) {
			return entry;
		}

		entry.setUuid((String) map.get(Entry.UUID));
		return entry;
	}
}
