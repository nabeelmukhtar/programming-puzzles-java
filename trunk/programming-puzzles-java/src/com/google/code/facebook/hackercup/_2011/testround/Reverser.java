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
public class Reverser extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String[] words = input.readLine().split(delimiter);
			for (int j = 0; j < words.length; j++) {
				output.print(f(words[j], j + 1));
				if (j == words.length - 1) {
					output.println();
				} else {
					output.print(" ");
				}
			}
		}
		output.flush();
	}

	private String f(String word, int i) {
		int length = word.length();
		if (length <= i) {
			return word;
		} else {
			int index = length / 2;
			return f(word.substring(index, length), i) + f(word.substring(0, index), i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Reverser().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
