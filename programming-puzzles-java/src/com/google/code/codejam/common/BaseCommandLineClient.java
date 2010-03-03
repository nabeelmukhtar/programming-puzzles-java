/**
 * 
 */
package com.google.code.codejam.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author nmukhtar
 *
 */
public abstract class BaseCommandLineClient {
	protected String delimiter = "";

	/**
	 * @param args
	 */
	protected void run(String[] args) {
		if (args.length < 1) {
			printHelp();
		} else {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(args[0]));
		    	String line = null;
		    	int lineNumber = 0;
	        	while((line = reader.readLine()) != null) {
	        		String[] tokens = line.split(delimiter);
	        		processTokens(++lineNumber, tokens);
	        	}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeReader(reader);
			}
		}
	}
	
	/**
	 *
	 */
	protected void printHelp() {
		System.err.println("The syntax to use this command line application is:");
		System.err.println("java " + getClass().getName() + " <inputfilename>");
	}
	
	/**
	 *
	 */
    protected void closeReader(Reader reader) {
    	if (reader != null) {
            try {
            	reader.close();
            } catch (IOException e) {
            	e.printStackTrace();	
            }
    	}
    }
	
	/**
	 *
	 */
	public abstract void processTokens(int lineNumber, String[] lineTokens);
}
