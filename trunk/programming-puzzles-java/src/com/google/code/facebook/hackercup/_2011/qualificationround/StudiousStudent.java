/**
 * 
 */
package com.google.code.facebook.hackercup._2011.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
			List<String> permutations = new ArrayList<String>();
			
			for (int j = 0; j < words.length; j++) {
				permutations.addAll(permute(words, j));
			}
			
			Collections.sort(permutations);
			
			output.println(permutations.get(0));
		}
		output.flush();
	}

	private List<String> permute(String[] words, int j) {
		List<String> permutations = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			builder.append(words[i]);
		}
		
		return permutations;
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
