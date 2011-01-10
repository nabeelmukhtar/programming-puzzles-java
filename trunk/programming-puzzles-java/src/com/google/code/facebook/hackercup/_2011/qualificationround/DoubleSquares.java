/**
 * 
 */
package com.google.code.facebook.hackercup._2011.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class DoubleSquares extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(input.readLine());
			int numRoots = (int) Math.ceil(Math.sqrt(X));
			int[] squares = new int[numRoots + 1];
			for (int j = 0; j <= numRoots; j++) {
				squares[j] = j * j;
			}
			int count = 0;
			for (int j = 0; j < squares.length; j++) {
				for (int k = j; k < squares.length; k++) {
					if (squares[j] + squares[k] == X) {
						count++;
					} else if (squares[j] + squares[k] > X) {
						break;
					}
				}
			}
			output.println(count);
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new DoubleSquares().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
