/**
 *
 */
package mz.co.mozview.frameworks.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Stélio Moiane
 *
 */
public class CalendarUtil {

	public static Calendar getStartOfDay(final Calendar date) {
		Calendar startDate = Calendar.getInstance();

		startDate.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
				date.get(Calendar.DATE), 0, 0, 0);

		return startDate;
	}

	public static Calendar getEndOfDay(final Calendar date) {
		Calendar endDate = Calendar.getInstance();

		endDate.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
				date.get(Calendar.DATE), 23, 59, 59);

		return endDate;
	}

	public static String formatedDate(final Date date) {
		SimpleDateFormat formator = new SimpleDateFormat("dd/MM/yyyy");
		return formator.format(date);
	}
}
