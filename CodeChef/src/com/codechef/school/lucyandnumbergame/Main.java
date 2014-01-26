package com.codechef.school.lucyandnumbergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	
	private static String noResult = "Nobody wins.";

	public static void main(String[] args) {
		int noOfTestCases=IOUtils.readInt();
		for(int i=0;i<noOfTestCases;i++){
			System.out.println(getOutput());
		}
	}

	private static String getOutput() {
		int n = IOUtils.readInt();
		String output = "";
		Map<Long, String> map = new TreeMap<Long, String>();
		List<Long> repeaters = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			String input = IOUtils.readLine();
			String name = input.split(" ")[0];
			long number = Long.parseLong(input.split(" ")[1]);
			if (map.containsKey(number)) {
				repeaters.add(number);

			} else {
				map.put(number, name);
			}
		}
		for (Entry<Long, String> entry : map.entrySet()) {
			if (!repeaters.contains(entry.getKey())) {
				output = entry.getValue();
				break;
			} else {
				output = noResult;
			}
		}
		return output;
	}
}
class IOUtils {
	private static BufferedReader reader;
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static int readInt(){
		try {
			return Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}
	
	public static String readLine(){
		try {
			return reader.readLine();
		} catch (IOException e) {
			return "";
		}
	}
}
