/*
 * ® 2014 - 2015 MozView Technologies - Maputo, Moçambique ®
 */
package mz.co.mozview.frameworks.core.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Este utilitário tem como objectivo escrever num ficheiro excel
 *
 * @author Stélio Moiane
 *
 */
public class XlsxFileWriterServiceImpl implements FileWriterService {

	public static final Logger logger = LoggerFactory.getLogger(XlsxFileWriterServiceImpl.class);

	@Override
	public void writeFile(final String fileName, final Map<String, List<Object>> dataMap) throws BusinessException {
		XlsxFileWriterServiceImpl.logger.info("Start writing a file...");

		try (OutputStream file = new FileOutputStream(new File(fileName)); XSSFWorkbook workbook = new XSSFWorkbook();) {

			XSSFSheet sheet = workbook.createSheet();

			int rowNumber = 0;
			for (String key : dataMap.keySet()) {
				XlsxFileWriterServiceImpl.logger.info("Writing the line " + (rowNumber + 1));
				Row row = sheet.createRow(rowNumber++);
				List<Object> dataList = dataMap.get(key);

				this.writingCells(row, dataList);
			}

			workbook.write(file);

			XlsxFileWriterServiceImpl.logger.info("End writing file. " + (rowNumber + 1) + " line(s) were writin...");

		} catch (final Exception e) {
			XlsxFileWriterServiceImpl.logger.error("Errors writing a file...");
			e.printStackTrace();
		}
	}

	private void writingCells(final Row row, final List<Object> dataList) {
		int cellNumber = 0;

		for (Object data : dataList) {
			Cell cell = row.createCell(cellNumber++);

			if (data instanceof String) {
				cell.setCellValue((String) data);
			} else if (data instanceof Integer) {
				cell.setCellValue((Integer) data);
			} else if (data instanceof Double) {
				cell.setCellValue((Double) data);
			} else if (data instanceof Boolean) {
				cell.setCellValue((Boolean) data);
			}
		}
	}

}
