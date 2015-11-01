/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class CurrencyFormatTest {

	@Test
	public void shouldFormatBigDeciamalToStringCurrency() {
		BigDecimal money = new BigDecimal("1505.30");
		String formatedMoney = CurrencyFormat.format(money, CurrencyFormat.MTS);

		assertEquals("1,505.30 MTs", formatedMoney);
	}

	@Test
	public void shouldNotFormatBigDecimalToCurrencyWithNullMoney() {
		String formatedMoney = CurrencyFormat.format(null, CurrencyFormat.MTS);

		assertEquals("0.00 MTs", formatedMoney);
	}

	@Test
	public void shouldNotFormatBigDecimalToCurrencyWithNullPattern() {
		String formatedMoney = CurrencyFormat.format(new BigDecimal("100.0"), null);

		assertEquals("0.00 MTs", formatedMoney);
	}

}
