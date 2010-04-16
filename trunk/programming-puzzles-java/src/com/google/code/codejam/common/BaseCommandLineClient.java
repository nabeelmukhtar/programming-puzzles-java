/**
 * 
 */
package com.google.code.codejam.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * @author nmukhtar
 * 
 */
public abstract class BaseCommandLineClient {
	protected String delimiter = "\\s";
	protected PrintWriter writer;

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
				writer = new PrintWriter(new FileWriter(args[1]));
				String line = null;
				int lineNumber = 0;
				while ((line = reader.readLine()) != null) {
					String[] tokens = line.split(delimiter);
					processTokens(++lineNumber, tokens);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeReader(reader);
				closeWriter(writer);
			}
		}
	}

	/**
	 * 
	 */
	protected void printHelp() {
		System.err
				.println("The syntax to run this command line application is:");
		System.err.println("java " + getClass().getName()
				+ " <inputfilename> <outputfilename>");
	}

	/**
	 * 
	 */
	protected void printLine(String line) {
		writer.println(line);
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
	protected void closeWriter(Writer writer) {
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 */
	protected String join(List<String> strings, String joiner) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strings.size(); i++) {
			builder.append(strings.get(i));
			if (i != strings.size() - 1) {
				builder.append(joiner);
			}
		}
		return builder.toString();
	}

	/**
	 * 
	 */
	public abstract void processTokens(int lineNumber, String[] lineTokens);
}
