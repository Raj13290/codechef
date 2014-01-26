package com.codechef.school.mikeandtask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int[] output = getOutput();
		System.out.println(output[0] + " " + output[1]);
	}

	private static int[] getOutput() {
		long[] nAndX = IOUtils.readLine(2);
		long[] array = IOUtils.readLine((int)nAndX[0]);
		return null;
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

