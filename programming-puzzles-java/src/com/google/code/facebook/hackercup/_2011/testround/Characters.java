/**
 * 
 */
package com.google.code.facebook.hackercup._2011.testround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Characters extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String text = input.readLine().toLowerCase();
			Set<Character> characters = new HashSet<Character>();
			for (int j = 0; j < text.length(); j++) {
				characters.add(text.charAt(j));
			}
			output.println(characters.size());
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Characters().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
