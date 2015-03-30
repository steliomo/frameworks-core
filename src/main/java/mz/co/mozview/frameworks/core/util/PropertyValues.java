/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * Esta classe dedica-se ao carregamentos de valores no ficheiro
 * "error_messages.properties"
 *
 * @author Stélio Moiane
 *
 */
@Component
public class PropertyValues {

	final static String fileName = "error_messages.properties";

	private Properties prop;

	public String getPropValues(final String keyValue) {
		this.prop = new Properties();

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

		try {

			if (inputStream == null) {

				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}

			this.prop.load(inputStream);

		} catch (IOException e) {
			// problemas ao carregar o ficheiro
		}

		return this.prop.getProperty(keyValue);
	}

	/**
	 * Ao usar este método não se esqueça de de passar um object em branco de
	 * seguida os restantes elementos do array. eg. getPropValues("key","",
	 * "stelio", "alima", "kamilah", "nailah", "camilo")
	 **/
	public String getPropValues(final String keyValue, final Object... params) {
		return MessageFormat.format(this.getPropValues(keyValue), params);
	}
}
