/**
 * 
 */
package com.google.code.codejam._2009.onlineround1_subroundB;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class TheNextNumber extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= T; i++) {
			output.printf("Case #%d: %s\n", i, getNextNumber(input));			
		}
	}

	private String getNextNumber(Scanner input) {
		String integer = input.nextLine();
		char[] digits = integer.toCharArray();
		for (int i = digits.length - 2; i > 0; i--) {
			int selected = -1;
			for (int j = i + 1; j < digits.length; j++) {
				if (selected < 0 || (digits[j] < digits[selected] && digits[j] > digits[i])) {
					selected = j;
				}
			}
			if (selected >= 0 && digits[selected] > digits[i]) {
				char temp = digits[selected];
				digits[selected] = digits[i];
				digits[i] = temp;
				char[] tempArr = Arrays.copyOfRange(digits, i + 1, digits.length);
				Arrays.sort(tempArr);
				for (int j = i + 1; j < digits.length; j++) {
					digits[j] = tempArr[j - i - 1];
				}
				return String.valueOf(digits);
			}
		}
		Arrays.sort(digits);
		char[] tempArr = new char[digits.length + 1];
		int nonzeroIndex = 0;

		for (int i = 0; i < digits.length; i++) {
			if (i == 0) {
				tempArr[i] = digits[i];
			} else {
				tempArr[i + 1] = digits[i];
			}
			if (digits[i] != '0' && nonzeroIndex == 0) {
				nonzeroIndex = i + 1;
			}
		}
		
		tempArr[1] = '0';
		if (nonzeroIndex != 0) {
			tempArr[0] = tempArr[nonzeroIndex];
			tempArr[nonzeroIndex] = '0';
		}
		return String.valueOf(tempArr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new TheNextNumber().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
