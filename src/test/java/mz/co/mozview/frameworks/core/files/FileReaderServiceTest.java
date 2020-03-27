/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import mz.co.mozview.frameworks.core.exception.BusinessException;
import mz.co.mozview.frameworks.core.util.GenericObject;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class FileReaderServiceTest {

	private FileReaderService fileReaderService;

	@Before
	public void setUp() {
		this.fileReaderService = new FileReaderServiceImpl();
	}

	@Test
	public void shouldReadXlsxFile() throws BusinessException {

		String fileName = "Teste.xlsx";

		List<GenericObject> dataList = this.fileReaderService.readfile(fileName);

		assertFalse(dataList.isEmpty());
		assertEquals(5, dataList.size());
	}
}
