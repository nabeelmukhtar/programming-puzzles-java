/**
 * 
 */
package com.google.code.codejam._2009.onsitefinals.yearofcodejam;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class AYearOfMoreCodeJam extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		String line = null;
		int lineNumber = 1;
		while ((line = input.readLine()) != null) {
			String[] lineTokens = line.split(delimiter);
			// TODO Auto-generated method stub
			lineNumber++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new AYearOfMoreCodeJam().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
