/**
 * 
 */
package com.google.code.codejam._2008.qualificationround.flyswatter;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class FlySwatter extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		final int numberOfTestCases = Integer.parseInt(input.readLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			output.println(String.format("Case #%d: %d", (i + 1), getProbability(input)));
		}
	}

	private double getProbability(BufferedReader input) throws Exception {
		double probability = 0.0;
		String[] tokens = input.readLine().split(delimiter);
		double f = Double.parseDouble(tokens[0]);
		double R = Double.parseDouble(tokens[1]);
		double t = Double.parseDouble(tokens[2]);
		double r = Double.parseDouble(tokens[3]);
		double g = Double.parseDouble(tokens[4]);
		
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
