package com.codechef.school.superfunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		System.out.println(getOutput());
		//1000000000
	}

	private static long getOutput() {
		long[] inputs = IOUtils.readLine(3);
		if (inputs == null) {
			return 0;
		}
		long output = 0;
		//boolean isNeven = (inputs[0] % 2 == 0);
		for (long i = 1; i < inputs[0]; i++) {

			if (isCoprime(inputs[0], i)) {
				// System.out.println(Math.pow(i, inputs[1]));
				output += Math.pow(i, inputs[1]);
			}
			// System.out.println("Output: "+ output);
		}
		if(output>inputs[2]){
			return output%inputs[2];
		}
		return output;

	}

	private static boolean isCoprime(long a, long b) {
		if (a == 1 || b == 1) {
			return true;
		}
		
		/*long remainder;
		long diviser;
		if (a > b) {
			remainder = a % b;
			diviser = b;
		} else {
			remainder = b % a;
			diviser = a;
		}
		// System.out.println(remainder + " " + diviser);
		while (remainder != 1 && remainder != 0) {
			long temp = remainder;
			remainder = diviser % remainder;
			diviser = temp;
		}
		if (remainder == 1) {
			return true;
		} else {
			return false;
		}*/
		 
	//	System.out.println("gcd("+a+","+ b+") = " + gcd(a, b));
		if (gcd(a, b) == 1) {
			return true;
		} else {
			return false;
		}
	}

	private static long gcd(long a, long b) {
		int shift;

		/* GCD(0,b) == b; GCD(a,0) == a, GCD(0,0) == 0 */
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		/*
		 * Let shift := lg K, where K is the greatest power of 2 dividing both a
		 * and b.
		 */
		for (shift = 0; ((a | b) & 1) == 0; ++shift) {
			a >>= 1;
			b >>= 1;
		}

		while ((a & 1) == 0) {
			a >>= 1;
		}

		/* From here on, a is always odd. */
		do {
			/* remove all factors of 2 in b -- they are not common */
			/* note: b is not zero, so while will terminate */
			while ((b & 1) == 0)
				/* Loop X */
				b >>= 1;

			/*
			 * Now a and b are both odd. Swap if necessary so a <= b, then set b
			 * = b - a (which is even). For bignums, the swapping is just
			 * pointer movement, and the subtruction can be done in-place.
			 */
			if (a > b) {
				long t = b;
				b = a;
				a = t;
			} // Swap a and b.
			b = b - a; // Here b >= a.
		} while (b != 0);

		/* restore common factors of 2 */
		return a << shift;
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
