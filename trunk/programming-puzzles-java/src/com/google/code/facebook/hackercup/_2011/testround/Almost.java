/**
 * 
 */
package com.google.code.facebook.hackercup._2011.testround;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Almost extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String[] tokens = input.readLine().split(delimiter);
			long a = Long.parseLong(tokens[0]);
			long c = Long.parseLong(tokens[1]);
			long b = Math.round((double) c / (double) a);
			output.println(b);
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Almost().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
