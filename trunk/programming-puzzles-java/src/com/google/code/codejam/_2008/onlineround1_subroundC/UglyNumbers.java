/**
 * 
 */
package com.google.code.codejam._2008.onlineround1_subroundC;

import java.io.PrintWriter;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class UglyNumbers extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new UglyNumbers().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
