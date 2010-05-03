/**
 * 
 */
package com.google.code.codejam._2008.qualificationround;

import java.io.PrintWriter;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class FlySwatter extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		final int numberOfTestCases = input.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			output.println(String.format("Case #%d: %g", (i + 1), getProbability(input)));
		}
	}

	private double getProbability(Scanner input) throws Exception {
		double probability = 0.0;
		double f = input.nextDouble();
		double R = input.nextDouble();
		double t = input.nextDouble();
		double r = input.nextDouble();
		double g = input.nextDouble();
		
		// TODO Auto-generated method stub
		return probability;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new FlySwatter().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
