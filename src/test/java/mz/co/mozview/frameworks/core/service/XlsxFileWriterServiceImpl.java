/*
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Stélio Moiane
 *
 */
public class XlsxFileWriterServiceImpl implements FileWriterService {

	public static final Logger logger = LoggerFactory.getLogger(XlsxFileWriterServiceImpl.class);

	@Override
	public void writeFile(final String fileName, final Map<String, List<Object>> dataMap) throws BusinessException {
		XlsxFileWriterServiceImpl.logger.info("Start writing a file...");

		try (InputStream file = new FileInputStream(new File(fileName))) {

			new XSSFWorkbook();

		} catch (final Exception e) {
		}

	}
}
