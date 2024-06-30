package org.gaas.kuhhandel.utils;

public class RandomIdUtils {
	public static String generateRandomId() {
		return Long.toHexString(Double.doubleToLongBits(Math.random()));
	}
}
