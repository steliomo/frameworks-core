/*
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.service;

import java.util.List;
import java.util.Map;

import mz.co.mozview.frameworks.core.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public interface FileWriterService {

	public abstract void writeFile(String fileName, Map<String, List<Object>> dataMap) throws BusinessException;

}
