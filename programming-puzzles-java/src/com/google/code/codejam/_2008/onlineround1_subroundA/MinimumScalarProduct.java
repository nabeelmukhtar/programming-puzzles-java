/**
 * 
 */
package com.google.code.codejam._2008.onlineround1_subroundA;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class MinimumScalarProduct extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		final int numberOfTestCases = Integer.parseInt(input.nextLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			output.printf("Case #%d: %d\n", (i + 1), getMinimumScalarProduct(input));			
		}
		output.flush();
	}

	private long getMinimumScalarProduct(Scanner input) throws Exception {
		int sizeOfVector = Integer.parseInt(input.nextLine());
		long[] v1Coordinates = new long[sizeOfVector];
		long[] v2Coordinates = new long[sizeOfVector];
		String[] v1String = input.nextLine().split(delimiter);
		for (int i = 0; i < sizeOfVector; i++) {
			v1Coordinates[i] = Long.parseLong(v1String[i]);
		}
		String[] v2String = input.nextLine().split(delimiter);
		for (int i = 0; i < sizeOfVector; i++) {
			v2Coordinates[i] = Long.parseLong(v2String[i]);
		}
		Arrays.sort(v1Coordinates);
		Arrays.sort(v2Coordinates);
		long minimumScalarProduct = 0;
		for (int i = 0; i < sizeOfVector; i++) {
			minimumScalarProduct += v1Coordinates[i] * v2Coordinates[sizeOfVector - i - 1];				
		}
		return minimumScalarProduct;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new MinimumScalarProduct().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
