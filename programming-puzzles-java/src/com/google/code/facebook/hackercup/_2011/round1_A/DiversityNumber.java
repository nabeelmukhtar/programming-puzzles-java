/**
 * 
 */
package com.google.code.facebook.hackercup._2011.round1_A;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class DiversityNumber extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new DiversityNumber().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
