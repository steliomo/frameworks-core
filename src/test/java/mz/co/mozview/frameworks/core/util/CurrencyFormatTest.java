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

}
