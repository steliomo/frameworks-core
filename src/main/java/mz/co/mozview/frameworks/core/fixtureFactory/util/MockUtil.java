/**
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.fixtureFactory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author Stélio Moiane
 *
 *         Este utilitário trata objectos mockáveis
 */
public final class MockUtil {

	private static final Logger logger = LoggerFactory.getLogger(MockUtil.class);

	public static <T> void mockField(final T mainObject, final String mockedObjectName, final T mockeObject) {

		ReflectionTestUtils.setField(MockUtil.unwrapProxy(mainObject), mockedObjectName, mockeObject);
	}

	private static Object unwrapProxy(Object bean) {
		/*
		 * If the given object is a proxy, set the return value as the object
		 * being proxied, otherwise return the given object.
		 */
		if (AopUtils.isAopProxy(bean) && (bean instanceof Advised)) {
			logger.info("Is about to mock");

			final Advised advised = (Advised) bean;

			try {
				bean = advised.getTargetSource().getTarget();
				logger.info("Mock was done.....");
			} catch (Exception e) {
				logger.error("Problems trying to mock....");
				e.printStackTrace();
			}
		}
		return bean;
	}
}
