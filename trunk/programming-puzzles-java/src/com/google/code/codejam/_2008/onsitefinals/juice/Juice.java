/**
 * 
 */
package com.google.code.codejam._2008.onsitefinals.juice;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Juice extends BaseCommandLineClient {

	/**
	 * @param lineNumber
	 * @param lineTokens
	 */
	@Override
	public void processTokens(int lineNumber, String[] lineTokens) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Juice().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}