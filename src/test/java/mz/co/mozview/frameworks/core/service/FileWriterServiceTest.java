/*
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class FileWriterServiceTest {

	private FileWriterService fileWriterService;

	@Before
	public void setUp() {
		this.fileWriterService = new XlsxFileWriterServiceImpl();
	}

	@Test
	public void shouldWriteXlsxFile() throws BusinessException {

		final String fileName = "teste.xlsx";

		final Map<String, List<Object>> dataMap = new HashMap<>();
		dataMap.put("HEADER", Arrays.asList("NAME", "SURNAME", "AGE"));
		dataMap.put("1", Arrays.asList("Stélio", "Moiane", 31));
		dataMap.put("2", Arrays.asList("Alima", "Moiane", 29));
		dataMap.put("3", Arrays.asList("Câmilo", "Moiane", 11));
		dataMap.put("4", Arrays.asList("Nailah", "Moiane", 3));
		dataMap.put("5", Arrays.asList("Kamilah", "Moiane", 2));

		this.fileWriterService.writeFile(fileName, dataMap);

		final File file = new File(fileName);

		Assert.assertTrue(file.exists());
	}
}
