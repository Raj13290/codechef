package com.codechef.school.chefinqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		System.out.println(getOutput());
	}

	private static long getOutput() {
		long nAndk[] = IOUtils.readLine(2);
		long[] queue = IOUtils.readLine((int)nAndk[0]);
		return 0;
	}

}
class IOUtils {
	private static BufferedReader reader;
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	// get array inputs
	public static long[] readLine(int size) {
		long array[] = new long[size];
		try {
			String line = reader.readLine();
			String[] numbers = line.split(" ");
			if (numbers.length != size) {
				throw new IOException();
			}
			for (int i = 0; i < numbers.length; i++) {
				array[i] = Long.parseLong(numbers[i]);
			}
		} catch (IOException e) {
			return null;
		}
		return array;
	}
}
