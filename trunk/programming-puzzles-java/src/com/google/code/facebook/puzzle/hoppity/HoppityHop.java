/**
 * 
 */
package com.google.code.facebook.puzzle.hoppity;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.puzzle.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class HoppityHop extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		long number = Long.parseLong(input.readLine());
		for (int i = 1; i <= number; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					output.println("Hop");
				} else {
					output.println("Hoppity");
				}
			} else if (i % 5 == 0) {
				output.println("Hophop");
			}
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new HoppityHop().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
