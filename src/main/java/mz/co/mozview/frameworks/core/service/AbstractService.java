/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.service;

import javax.inject.Inject;

import mz.co.mozview.frameworks.core.util.PropertyValues;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Stélio Moiane
 *
 */
@Transactional
public abstract class AbstractService {

	@Inject
	protected PropertyValues propertyValues;
}
