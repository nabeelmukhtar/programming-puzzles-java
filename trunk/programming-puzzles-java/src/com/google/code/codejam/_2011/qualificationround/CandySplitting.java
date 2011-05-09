package com.google.code.codejam._2011.qualificationround;
/**
 * 
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 * 
 */
public class CandySplitting extends BaseCommandLineClient {
	private static final String NO = "NO";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new CandySplitting().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}

	/**
	 * @param input TODO
	 * @param output TODO
	 * @throws Exception TODO
	 * 
	 */
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for(int i = 1; i <= T; i++) {
			output.printf("Case #%d: %s\n", i, getSeansPileValue(input));			
		}
	}

	private String getSeansPileValue(Scanner input) {
		int N = Integer.parseInt(input.nextLine());
		String[] tokens = input.nextLine().split(delimiter);
		int[] candyValues = new int[N];
		for (int i = 0; i < candyValues.length; i++) {
			candyValues[i] = Integer.parseInt(tokens[i]);
		}
		Arrays.sort(candyValues);
		for (int i = 1; i < candyValues.length; i++) {
			int[] patricksPile = new int[i];
			System.arraycopy(candyValues, 0, patricksPile, 0, i);
			int[] seansPile = new int[candyValues.length - i];
			System.arraycopy(candyValues, i, seansPile, 0, candyValues.length - i);
			if (sumPatrick(patricksPile) == sumPatrick(seansPile)) {
				return String.valueOf(sumSean(seansPile));
			}
		}
		return NO;
	}

	private int sumSean(int[] seansPile) {
		int sum = 0;
		for (int i = 0; i < seansPile.length; i++) {
			sum += seansPile[i];
		}
		return sum;
	}

	private int sumPatrick(int[] patricksPile) {
		int sum = 0;
		for (int i = 0; i < patricksPile.length; i++) {
			String sumB = Integer.toBinaryString(sum);
			String valueB = Integer.toBinaryString(patricksPile[i]);
			sum = sumPatric(sumB, valueB);			
		}
		return sum;
	}

	private int sumPatric(String sumB, String valueB) {
		int length = 0;
		if (sumB.length() >= valueB.length()) {
			int padding = sumB.length() - valueB.length();
			for (int i = 0; i < padding; i++) {
				valueB = "0" + valueB;
			}
			length = sumB.length();
		} else {
			int padding = valueB.length() - sumB.length();
			for (int i = 0; i < padding; i++) {
				sumB = "0" + sumB;
			}
			length = valueB.length();
		}
		StringBuilder builder = new StringBuilder();
		for (int i = length - 1; i >= 0; i--) {
			char char1 = valueB.charAt(i);
			char char2 = sumB.charAt(i);
			builder.insert(0, ((char1 == char2)? '0' : '1'));
		}
		return Integer.parseInt(builder.toString(), 2);
	}
}
