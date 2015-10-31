/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Formatador para meticais
 *
 * @author Stélio Moiane
 *
 */
public class CurrencyFormat {

	public static final String MTS = "#,##0.00 MTs";

	private static final String DEFAULT = "0.00 MTs";

	public static String format(final BigDecimal money, final String pattern) {

		if (money == null) {
			return DEFAULT;
		}

		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		return decimalFormat.format(money.doubleValue());
	}

}
