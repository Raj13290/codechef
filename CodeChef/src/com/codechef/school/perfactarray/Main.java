package com.codechef.school.perfactarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		System.out.println(getOutput());

	}

	private static int getOutput() {
		long[] inputs = IOUtils.readLine(2);
		long n = inputs[0];
		long k = inputs[1];
		long[] array = IOUtils.readLine((int) n);
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
