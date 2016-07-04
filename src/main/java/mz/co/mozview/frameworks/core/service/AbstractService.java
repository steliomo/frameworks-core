/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.service;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Stélio Moiane
 *
 */
@Transactional(noRollbackFor = { NoResultException.class })
public abstract class AbstractService {

}
