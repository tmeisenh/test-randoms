package com.indexoutofbounds.random;

import java.util.Random;

public class Numbers {

	public static final int DEFAULT_MINIMUM = Short.MIN_VALUE;
	public static final int DEFAULT_MAXIMUM = Short.MAX_VALUE;

	private Numbers() {
	}

	/**
	 * Generates a number between Short.MIN_VALUE and Short.MAX_VALUE
	 * 
	 * @return Number
	 */
	public static Number getRandomNumber() {
		return getRandomNumber(DEFAULT_MINIMUM, DEFAULT_MAXIMUM);
	}

	/**
	 * Generates a number between min and max
	 * 
	 * @param min
	 *            minimum value
	 * @param max
	 *            maximum value
	 * @return Number
	 * @throws RuntimeException
	 *             is min == max || min > max
	 */
	public static Number getRandomNumber(int min, int max) {
		checkNumbers(min, max);
		return findRandomNumber(min, max);
	}

	/**
	 * Generates a random positive number between 1 and max
	 * 
	 * @param max
	 *            maximum value
	 * @return
	 */
	public static Number getRandomPositiveNumber(int max) {
		return findRandomNumber(1, max);
	}

	private final static Number findRandomNumber(int min, int max) {
		Random random = new Random(System.currentTimeMillis());
		Number number = random.nextInt(max - min + 1) + min;
		return number;
	}

	private static void checkNumbers(int min, int max) {
		if (min == max || min > max) {
			throw new RuntimeException("Minimum must be smaller than max");
		}
	}
}
