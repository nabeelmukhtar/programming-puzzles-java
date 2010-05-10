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
public class FairWarning extends BaseCommandLineClient {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new FairWarning().run(args);
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
		// TODO-NM: Solve this puzzle.
	}
}
