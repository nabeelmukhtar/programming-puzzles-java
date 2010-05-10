package com.google.code.codejam._2010.qualificationround;
/**
 * 
 */
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 * 
 */
public class SnapperChain extends BaseCommandLineClient {
	protected final String ON = "ON";
	protected final String OFF = "OFF";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new SnapperChain().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
	
	/**
	 * @param input TODO
	 * @param output TODO
	 * @throws Exception TODO
	 * 
	 */
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for(int i = 1; i <= T; i++) {
			output.printf("Case #%d: %s\n", i, getStateOfTheLightBulb(input));			
		}
	}

	private String getStateOfTheLightBulb(Scanner input) {
		String[] tokens = input.nextLine().split(delimiter);
		int N = Integer.parseInt(tokens[0]);
		int K = Integer.parseInt(tokens[1]);
		final int[] states = new int[N];
		for (int i = 0; i < K; i++) {
			for (int j = N - 1; j > 0; j--) {
				boolean on = true;
				for (int k = 0; k < j; k++) {
					if (states[k] == 0) {
						on = false;
					}
				}
				if (on) {
					states[j] = (states[j] == 0)? 1 : 0;
				}
			}
			states[0] = (states[0] == 0)? 1 : 0;
		}
		return (states[N - 1] == 1) ? ON : OFF;
	}
}
