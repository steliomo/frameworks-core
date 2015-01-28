/**
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.fixtureFactory.util;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author Stélio Moiane
 *
 *         Este utilitário trata objectos mocéveis
 */
public final class MockUtil {

	public static <T> void setFieldOnRefletion(final T mainObject, final String mockedObjectName, final T mockeObject)
			throws Exception {

		ReflectionTestUtils.setField(MockUtil.unwrapProxy(mainObject), mockedObjectName, mockeObject);
	}

	private static Object unwrapProxy(Object bean) throws Exception {
		/*
		 * If the given object is a proxy, set the return value as the object
		 * being proxied, otherwise return the given object.
		 */
		if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {

			final Advised advised = (Advised) bean;

			bean = advised.getTargetSource().getTarget();
		}

		return bean;
	}
}
