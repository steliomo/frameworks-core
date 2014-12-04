/**
 * 
 */
package mz.co.mozview.frameworks.fixturefactory;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Stélio Klésio Adriano Moiane
 * 
 */
// carrega todas a fixtures existentes
public class LoaderFactory {

	public static void loadTemplates(String basePackage) {
		for (Class<?> clazz : getClassesPackage(basePackage)) {
			if (!clazz.isInterface()
					&& TemplateLoader.class.isAssignableFrom(clazz)) {
				try {
					((TemplateLoader) clazz.newInstance()).load();
				} catch (Exception e) {
					throw new RuntimeException(String.format(
							"template %s not loaded", clazz.getName()), e);
				}
			}
		}
	}

	private static Set<Class<?>> getClassesPackage(String packageName) {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();

			URL resource = classLoader.getResource(packageName
					.replace('.', '/'));

			classes.addAll(scanClassesFromDirectory(
					new File(URLDecoder.decode(resource.getPath(), "UTF-8")),
					packageName));
		} catch (Exception x) {
			throw new IllegalArgumentException("invalid package");
		}

		return classes;
	}

	private static Collection<Class<?>> scanClassesFromDirectory(
			File directory, String packageName) {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		if (directory.exists() && directory.isDirectory()) {
			String[] files = directory.list();
			for (String fileItem : files) {
				if (fileItem.endsWith(".class")) {
					try {
						classes.add(Class.forName(packageName.concat(".")
								.concat(fileItem.replace(".class", ""))));
					} catch (Exception e) {
						throw new IllegalArgumentException("Invalid package "
								+ packageName);
					}
				} else if (!fileItem.matches(".+\\..+")) {
					File dir = new File(directory, fileItem);
					if (dir.isDirectory()) {
						classes.addAll(scanClassesFromDirectory(dir,
								packageName.concat(".").concat(fileItem)));
					}
				}
			}
		}
		return classes;
	}

}
