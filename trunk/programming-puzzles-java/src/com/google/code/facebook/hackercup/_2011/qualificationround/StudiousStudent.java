/**
 * 
 */
package com.google.code.facebook.hackercup._2011.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class StudiousStudent extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String[] tokens = input.readLine().split(delimiter);
			int M = Integer.parseInt(tokens[0]);
			String[] words = Arrays.copyOfRange(tokens, 1, tokens.length);
			Arrays.sort(words);
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < words.length; j++) {
				builder.append(words[j]);
			}
			
			output.println(builder.toString());
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new StudiousStudent().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
