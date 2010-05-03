/**
 * 
 */
package com.google.code.facebook.dinoisland;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class DinosaurIsland extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new DinosaurIsland().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
