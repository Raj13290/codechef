/**
 * 
 */
package com.codechef.school.chefandgift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rajesh
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long noOfTestCases = IOUtils.readLong();
		for(long i=0;i<noOfTestCases;i++){
			System.out.println(getOutput());
		}
	}

	private static long getOutput() {
		int noOfNumbers = (int) IOUtils.readLine(1)[0];
		int []numbers = IOUtils.readLine(noOfNumbers);
		return processInputs(numbers);
	}

	private static long processInputs(int[] numbers) {
		long minValue = numbers[0];
		long maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			long []minMax = getMinMax(minValue, maxValue, numbers[i]);
			minValue = minMax[0];
			maxValue = minMax[1];
			System.err.println("Min value: "+ minValue+ ", Max Value: "+ maxValue);
		}
		return minValue;
	}

	private static long[] getMinMax(long minValue, long maxValue, int i) {
		long minMax[] = new long[2];
		long a = minValue + i;
		long b = minValue - i;
		long c = minValue * i;
		long tempMin = a<b?a<c?a:c:b<c?b:c;
		long tempMax = a>b?a>c?a:c:b>c?b:c;
		a = maxValue + i;
		b = maxValue - i;
		c = maxValue * i;
		long temp2Min = a<b?a<c?a:c:b<c?b:c;
		long temp2Max = a>b?a>c?a:c:b>c?b:c;
		minMax[0] = tempMin<temp2Min?tempMin:temp2Min;
		minMax[1] = tempMax>temp2Max?tempMax:temp2Max;
		return minMax;
	}
}
class IOUtils {
	private static BufferedReader reader;
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	public static long readLong(){
		try {
			return Long.parseLong(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	// get array inputs
	public static int[] readLine(int size) {
		int array[] = new int[size];
		try {
			String line = reader.readLine();
			String[] numbers = line.split(" ");
			if (numbers.length != size) {
				throw new IOException();
			}
			for (int i = 0; i < numbers.length; i++) {
				array[i] = Integer.parseInt(numbers[i]);
			}
		} catch (IOException e) {
			return null;
		}
		return array;
	}
}
