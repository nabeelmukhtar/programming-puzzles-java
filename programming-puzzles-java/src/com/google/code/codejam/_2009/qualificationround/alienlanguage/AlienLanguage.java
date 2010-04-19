/**
 * 
 */
package com.google.code.codejam._2009.qualificationround.alienlanguage;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class AlienLanguage extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		String line = null;
		int lineNumber = 1;
		int numberOfTokens = 0;
		int numberOfWords = 0;
		int numberOfSamples = 0;
		List<String> dictionary = new ArrayList<String>();
		while ((line = input.readLine()) != null) {
			String[] lineTokens = line.split(delimiter);
			if (lineNumber == 1) {
				numberOfTokens = Integer.parseInt(lineTokens[0]);
				numberOfWords = Integer.parseInt(lineTokens[1]);
				numberOfSamples = Integer.parseInt(lineTokens[2]);
			} else if (dictionary.size() < numberOfWords) {
				dictionary.add(lineTokens[0]);
			} else {
				int matchCount = 0;
				for (String word : dictionary) {
					if (Pattern.matches(convertToRegex(lineTokens[0]), word)) {
						matchCount ++;
					}
				}
				output.println(String.format("Case #%d: %d", lineNumber - numberOfWords - 1, matchCount));
			}
			lineNumber++;
		}
	}

	private String convertToRegex(String string) {
		StringBuilder builder = new StringBuilder();
		for (char c : string.toCharArray()) {
			if (c == '(') {
				builder.append('[');
			} else if (c == ')') {
				builder.append(']');
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new AlienLanguage().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
