/**
 * 
 */
package com.google.code.facebook.hackercup._2012.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Billboards extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			String line = input.readLine();
			String[] tokens = line.split(delimiter);
			int W = Integer.parseInt(tokens[0]);
			int H = Integer.parseInt(tokens[1]);
			int sSize = 0;
			String[] STokens = new String[tokens.length - 2];
			for (int j = 0; j < STokens.length; j++) {
				STokens[j] = tokens[j + 2];
				sSize += STokens[j].length();
			}
			
			int maxSize = W * H / sSize;
			for (int size = maxSize; size >= 0; size --) {
				if (fits(STokens, W, H, size)) {
					output.println("Case #" + (i + 1) + ": " + size);
					break;
				}
			}
		}
		output.flush();
	}

	private boolean fits(String[] sTokens, int W, int H, int size) {
		int totalWidth = 0;
		int totalHeight = size;
		
		for (int i = 0; i < sTokens.length; i++) {
			if (totalWidth + (size * sTokens[i].length()) < W) {
				totalWidth += size * sTokens[i].length() + size;
			} else if ((totalHeight + size) <= H) {
				i--;
				totalHeight += size;
				totalWidth = 0;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Billboards().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
