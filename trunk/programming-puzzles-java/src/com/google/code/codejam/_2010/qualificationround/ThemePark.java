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
public class ThemePark extends BaseCommandLineClient {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new ThemePark().run(args);
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
		for (int i = 1; i <= T; i++) {
			output.printf("Case #%d: %d\n", i, getNumberOfEuros(input));			
		}
	}

	private long getNumberOfEuros(Scanner input) {
		String[] tokens = input.nextLine().split(delimiter);
		long R = Long.parseLong(tokens[0]);
		long k = Long.parseLong(tokens[1]);
		int N = Integer.parseInt(tokens[2]);
		long[] queue = new long[N];
		tokens = input.nextLine().split(delimiter);
		for (int i = 0; i < N; i++) {
			queue[i] = Integer.parseInt(tokens[i]);
		}
		long eurosEarned = 0;
		for (int i = 0; i < R; i++) {
			long currentCapacity = 0;
			int fitIndex = 0;
			while (fitIndex < queue.length && (queue[fitIndex] + currentCapacity) <= k) {
				currentCapacity += queue[fitIndex];
				fitIndex++;
			}
			eurosEarned += currentCapacity;
			rotateQueue(queue, fitIndex);
		}
		return eurosEarned;
	}

	private void rotateQueue(long[] queue, int fitIndex) {
		long[] temp = new long[fitIndex];
		for (int i = 0; i < queue.length; i++) {
			if (i < fitIndex) {			
				temp[i] = queue[i];
			} else {
				queue[i - fitIndex] = queue[i];
			}
		}
		int count = 0;
		for (int i = queue.length - fitIndex; i < queue.length; i++) {
			queue[i] = temp[count++];
		}
	}
}
