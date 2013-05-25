package com.indexoutofbounds.random;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest {

	@Before
	public void setUp() {
	}

	private void compareNumbers(final Number randomNumber, final int min, final int max) {
		assertTrue(min <= randomNumber.intValue() && randomNumber.intValue() <= max);
	}

	@Test
	public void testRandomNumberIsWithinDefaultMinMaxRange() {
		for (int i = 0; i < 100000; i++) {
			Number randomNumber = Numbers.getRandomNumber();
			compareNumbers(randomNumber, Numbers.DEFAULT_MINIMUM, Numbers.DEFAULT_MAXIMUM);
		}
	}

	@Test
	public void testRandomNumberIsWithinCustomRange() {
		for (int i = 0; i < 100000; i++) {
			Number randomNumber = Numbers.getRandomNumber(1, 20);
			compareNumbers(randomNumber, 0, 20);
		}
	}

	@Test
	public void testRandomPositiveNumber() {
		for (int i = 0; i < 100000; i++) {
			Number randomNumber = Numbers.getRandomPositiveNumber(100);
			assertTrue(randomNumber.intValue() > 0);
			compareNumbers(randomNumber, 1, 100);
		}
	}

	@Test(expected = RuntimeException.class)
	public void testWhenMinAndMaxAreTheSameThenRTEIsThrown() {
		Numbers.getRandomNumber(1, 1);
	}

	@Test(expected = RuntimeException.class)
	public void testWhenMinIsGreaterThanMaxThenRTEIsThrown() {
		Numbers.getRandomNumber(2, 1);
	}
}
