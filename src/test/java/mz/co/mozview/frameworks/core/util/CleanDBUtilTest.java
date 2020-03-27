/*
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class CleanDBUtilTest {

	private CleanDBUtil cleanDBUtil;

	@Before
	public void setUp() {
		CleanDBUtil.pushEntity("Alima");
		CleanDBUtil.pushEntity("Stelio");
		CleanDBUtil.pushEntity("Nailah");
		CleanDBUtil.pushEntity("Kamilah");

		EntityManagerFactory entityManager = mock(EntityManagerFactoryImpl.class);
		this.cleanDBUtil = new CleanDBUtil(entityManager);
	}

	@Test
	public void shouldCleanAllData() {

		this.cleanDBUtil.cleanDB();

		assertTrue(CleanDBUtil.entitiesCreated.isEmpty());
	}

	@Test
	public void shouldNotRepeatTableNames() {
		CleanDBUtil.pushEntity("Kamilah");
		CleanDBUtil.pushEntity("Kamilah");
		assertEquals(4, CleanDBUtil.entitiesCreated.size());
	}

	@After
	public void tearDown() {
		this.cleanDBUtil.cleanDB();
	}
}
