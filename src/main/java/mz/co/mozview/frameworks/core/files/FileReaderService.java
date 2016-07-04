/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.files;

import java.util.List;

import mz.co.mozview.frameworks.core.exception.BusinessException;
import mz.co.mozview.frameworks.core.util.GenericObject;

/**
 * @author Stélio Moiane
 *
 */
public interface FileReaderService {

	public abstract List<GenericObject> readfile(String fileName) throws BusinessException;

}
