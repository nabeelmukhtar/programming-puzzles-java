/**
 * 
 */
package com.google.code.facebook.hackercup._2011.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class PegGame extends BaseCommandLineClient {
	
	DecimalFormat FORMAT = new DecimalFormat("0.000000");

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String[] tokens = input.readLine().split(delimiter);
			int index = 0;
			int R = Integer.parseInt(tokens[index++]);
			int C = Integer.parseInt(tokens[index++]);
			int K = Integer.parseInt(tokens[index++]);
			int M = Integer.parseInt(tokens[index++]);
			double[][] grid = new double[R][C];
			for (int j = 0; j < M; j++) {
				int r = Integer.parseInt(tokens[index++]);
				int c = Integer.parseInt(tokens[index++]);
				grid[r][c] = -1;
			}
			
			if (K == 0) {
				grid[grid.length - 1][K] = 1;
			} else {
				grid[grid.length - 1][K] = 0.5;
			}
			if (K == C - 2) {
				grid[grid.length - 1][K + 1] = 1;
			} else {
				grid[grid.length - 1][K + 1] = 0.5;
			}
			
			for (int j = grid.length - 2; j >= 0; j--) {
				for (int k = 0; k < C; k++) {
					if (grid[j][k] != -1) {
						if (j % 2 == 0) {
							if (k == 0) {
								double rightChild = grid[j + 1][k];
								if (rightChild == -1) {
									rightChild = grid[j + 2][k + 1];
								}
								grid[j][k] = rightChild * 1;  
							} else {
								double leftChild = grid[j + 1][k - 1];
								if (leftChild == -1) {
									leftChild = grid[j + 2][k];
								}
								if (k == C - 1) { 
									grid[j][k] = leftChild * 1;  
								} else {
									double rightChild = grid[j + 1][k];
									if (rightChild == -1) {
										rightChild = grid[j + 2][k + 1];
									}
									grid[j][k] = rightChild * 0.5 + leftChild * 0.5;  
								}
							}
						} else if (k < C - 1) {
							double leftChild = grid[j + 1][k];
							double rightChild = grid[j + 1][k + 1];
							if (rightChild == -1) {
								rightChild = grid[j + 2][k + 1];
							}
							if (leftChild == -1) {
								leftChild = grid[j + 2][k - 1];
							}
							grid[j][k] = leftChild * 0.5 + rightChild * 0.5;  
						}
					}
				}
				
			}
			int position = 0;
			double probability = 0.0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[0][j] > probability) {
					position = j;
					probability = grid[0][j];
				}
			}
			output.println(position + " " + FORMAT.format(probability));
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new PegGame().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
