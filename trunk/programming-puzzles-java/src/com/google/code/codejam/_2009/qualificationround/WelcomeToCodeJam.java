/**
 * 
 */
package com.google.code.codejam._2009.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class WelcomeToCodeJam extends BaseCommandLineClient {
	private static final String WELCOME = "welcome to code jam";

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		String line = null;
		int lineNumber = 1;
		int numberOfTestCases = 0;
		int testCase = 1;
		while ((line = input.readLine()) != null) {
			if (lineNumber == 1) {
				numberOfTestCases = Integer.parseInt(line);
			} else {
				long occurrences = getNumberOfOccurrences(line, WELCOME);
				output.println(String.format("Case #%d: %s", testCase, getFormattedString(occurrences)));
				output.flush();
				testCase++;
			}
			lineNumber++;
		}
	}

	private Object getFormattedString(long occurrences) {
		String formatted = String.valueOf(occurrences);
		if (formatted.length() < 4) {
			for (int i = formatted.length(); i < 4; i++) {
				formatted = "0" + formatted;
			}
		} else if (formatted.length() > 4) {
			formatted = formatted.substring(formatted.length() - 4);
		}
		return formatted;
	}

	private long getNumberOfOccurrences(String line, String searchString) {
		long count = 0;
		// copied from the web
		long ans[][] = new long[line.length()+1][searchString.length()+1];
		
		ans[0][0] = 1;
		for( int i = 0; i < line.length(); i++) {
			for( int j = 0; j < searchString.length(); j++ ){
				if( searchString.charAt(j) == line.charAt(i)) {
					ans[i+1][j+1] = (ans[i][j] + ans[i+1][j+1]) % 10000;
				}
				ans[i+1][j] = (ans[i][j] + ans[i+1][j]) % 10000;
			}
		}
		for( int i = 0; i <= line.length(); i++) {
			count = (count + ans[i][searchString.length()]) % 10000;
		}
		// original solution. very inefficient. Also count overflows for large file.
//		if (!searchString.isEmpty()) {
//			for (int i = 0; i < line.length(); i++) {
//				if (line.charAt(i) == searchString.charAt(0)) {
//					if (i < line.length() - 1) {
//						count += getNumberOfOccurrences(line.substring(i + 1), searchString.substring(1));
//					} else if (searchString.length() == 1) {
//						count++;
//					}
//				}
//			}
//		} else {
//			return 1;
//		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new WelcomeToCodeJam().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
