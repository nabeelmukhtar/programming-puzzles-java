/**
 * 
 */
package com.google.code.codejam._2009.onlineround1_subroundB;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class SquareMath extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= T; i++) {
			output.printf("Case #%d:\n", i);
			printPaths(input, output);
		}
	}

	private void printPaths(Scanner input, PrintWriter output) {
		String[] tokens = input.nextLine().split(delimiter);
		int W = Integer.parseInt(tokens[0]);
		int Q = Integer.parseInt(tokens[1]);
		char[][] arithmeticSquare = new char[W][W];
		for (int i = 0; i < W; i++) {
			arithmeticSquare[i] = input.nextLine().toCharArray();
		}
		tokens = input.nextLine().split(delimiter);
		for (int i = 0; i < tokens.length; i++) {
			printPath(arithmeticSquare, Integer.parseInt(tokens[i]), output);
		}
	}

	private void printPath(char[][] arithmeticSquare, int query, PrintWriter output) {
	}
	
	private int applyOperator(char op, int i, int j) {
		switch (op) {
		case '+':
			return i + j;

		case '-':
			return i - j;
			
		default:
			throw new IllegalArgumentException("Illegal operator found:" + op);
		}		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new SquareMath().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
	
	public static class PathComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {
				return o1.compareTo(o2);
			}
		}
	}
}
