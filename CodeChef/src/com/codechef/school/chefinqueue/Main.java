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
		long fearfullness = 1;
		long[] stack = new long[(int)nAndk[0]];
		int[] indexs = new int[(int) nAndk[0]];
		stack[0] =queue[0];
		int topOfStack = 0;
		for(int i=1;i<queue.length;i++){
			// using stack technique
			while (topOfStack>=0 && stack[topOfStack] > queue[i]) {
				//System.out.println(topOfStack);
				fearfullness *= (i - indexs[topOfStack] + 1);
				fearfullness %= 1000000007;
				topOfStack--;
				//System.out.println("fearfullness= " + fearfullness);
			}

			// push to stack
			topOfStack++;
			stack[topOfStack] = queue[i];
			indexs[topOfStack] = i;
			//displayStack(stack, topOfStack);
		}
		
		return fearfullness;
	}

	/*private static void displayStack(long[] stack, int topOfStack) {
		for(int i=0;i<=topOfStack;i++){
			System.out.print(" "+ stack[i]);
		}
		System.out.println();
	}*/

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
