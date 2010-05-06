/**
 * 
 */
package com.google.code.codejam._2009.onlineround1_subroundA;

import java.io.PrintWriter;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class MultibaseHappiness extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for (int i = 0; i < T; i++) {
			output.printf("Case #%d: %d\n", (i + 1), getHappyNumber(input.nextLine()));			
		}
	}

	private int getHappyNumber(String nextLine) {
		String[] tokens = nextLine.split(delimiter);
		int[] bases = new int[tokens.length];
		for (int i = 0; i < bases.length; i++) {
			bases[i] = Integer.parseInt(tokens[i]);
		}
		int happyNumber = 2;
		while (true) {
			boolean found = true;
			for (int i = 0; i < bases.length; i++) {
				int sum = calculateSum(Integer.toString(happyNumber, bases[i]).toCharArray(), bases[i]);
				if (sum != 1) {
					found = false;
					happyNumber++;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		return happyNumber;
	}

	private int calculateSum(char[] charArray, int i) {
		int sum = 0;
		for (int j = 0; j < charArray.length; j++) {
			sum += (int) charArray[j] - 48;
		}
		char[] charArray2 = Integer.toString(sum, i).toCharArray();
		if (charArray2.length > 1) {
			sum = calculateSum(charArray2, i);
		}
		
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new MultibaseHappiness().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
