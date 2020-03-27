/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author Stélio Moiane
 *
 */
public class DateUtil {

	public static Calendar getStartOfDay(final Calendar value) {

		if (value == null) {
			return null;
		}

		final Calendar calendar = Calendar.getInstance();

		calendar.set(value.get(Calendar.YEAR), value.get(Calendar.MONTH), value.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	public static Calendar getEndOfDay(final Calendar value) {
		if (value == null) {
			return null;
		}

		final Calendar calendar = Calendar.getInstance();

		calendar.set(value.get(Calendar.YEAR), value.get(Calendar.MONTH), value.get(Calendar.DATE), 23, 59, 59);

		return calendar;
	}

	public static Calendar toCalendar(final LocalDate value) {

		if (value == null) {
			return null;
		}

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(value));

		return calendar;
	}

	public static String toString(final LocalDate value) {

		if (value == null) {
			return null;
		}

		return value.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public static String toString(final LocalDate value, final String pattern) {

		if (value == null) {
			return null;
		}

		return value.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String toString(final LocalDateTime value, final String pattern) {

		if (value == null) {
			return null;
		}

		return value.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDate toLocalDate(final String value) {

		if (value == null) {
			return null;
		}

		return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public static LocalDate toLocalDate(final String value, final String pattern) {

		if (value == null) {
			return null;
		}

		return LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
	}
}
