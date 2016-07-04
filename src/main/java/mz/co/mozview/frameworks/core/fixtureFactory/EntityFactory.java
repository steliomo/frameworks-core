/**
 * 
 */
package mz.co.mozview.frameworks.core.fixtureFactory;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;

/**
 * @author Stélio Klésio Adriano Moiane
 * 
 */
public class EntityFactory {

	// esta devolve uma instancia do objecto
	public static <T> T gimme(final Class<T> clazz, final String label) {
		return Fixture.from(clazz).gimme(label);
	}

	// esta devolve um lista do objecto
	public static <T> List<T> gimme(final Class<T> clazz, final int elements,
			final String label) {
		return Fixture.from(clazz).gimme(elements, label);
	}

}
