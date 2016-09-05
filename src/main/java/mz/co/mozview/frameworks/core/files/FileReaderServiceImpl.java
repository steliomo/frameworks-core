/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mz.co.mozview.frameworks.core.exception.BusinessException;
import mz.co.mozview.frameworks.core.util.GenericObject;

/**
 * @author Stélio Moiane
 *
 */
@Service(FileReaderService.NAME)
public class FileReaderServiceImpl implements FileReaderService {

	private static final Logger logger = LoggerFactory.getLogger(FileReaderServiceImpl.class);

	@Override
	public List<GenericObject> readfile(final String fileName) throws BusinessException {
		final List<GenericObject> dataList = new ArrayList<>();

		try (InputStream file = new FileInputStream(new File(fileName));
				XSSFWorkbook workbook = new XSSFWorkbook(file);) {

			final XSSFSheet sheet = workbook.getSheetAt(0);

			final Iterator<Row> rowIterator = sheet.iterator();
			final List<String> headers = new ArrayList<>();

			while (rowIterator.hasNext()) {

				final Row row = rowIterator.next();
				final Iterator<Cell> cellIterator = row.iterator();

				if (headers.isEmpty()) {
					logger.info("Filling the headers....");
					this.fillHeaders(headers, cellIterator);
					continue;
				}

				this.fillObjects(cellIterator, headers, dataList);
			}

			logger.info("Finish to read the file...");

		} catch (final Exception e) {
			logger.error("Error reading a file....");
			e.printStackTrace();
		}

		return dataList;
	}

	private void fillObjects(final Iterator<Cell> cellIterator, final List<String> headers,
			final List<GenericObject> dataList) {
		int cellNumber = 0;

		final GenericObject data = new GenericObject();

		while (cellIterator.hasNext()) {
			final Cell cell = cellIterator.next();

			if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
				data.putValue(headers.get(cellNumber), cell.getNumericCellValue());
			} else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
				data.putValue(headers.get(cellNumber), cell.getStringCellValue());
			} else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
				data.putValue(headers.get(cellNumber), cell.getBooleanCellValue());
			}

			cellNumber++;
		}

		dataList.add(data);
	}

	private void fillHeaders(final List<String> headers, final Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			final Cell cell = cellIterator.next();
			headers.add(cell.getStringCellValue());
		}
	}
}
