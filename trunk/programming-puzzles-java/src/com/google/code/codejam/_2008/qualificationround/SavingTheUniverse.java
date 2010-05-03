/**
 * 
 */
package com.google.code.codejam._2008.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class SavingTheUniverse extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		final int numberOfTestCases = Integer.parseInt(input.nextLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			output.println(String.format("Case #%d: %d", i + 1, getNumberOfSwitches(input)));			
		}
		output.flush();
	}

	private int getNumberOfSwitches(Scanner input) throws Exception {
		final int numberOfSearchEngines = Integer.parseInt(input.nextLine());
		final String[] searchEngineNames = new String[numberOfSearchEngines];
		for (int i = 0; i < numberOfSearchEngines; i++) {
			searchEngineNames[i] = input.nextLine();
		}
		final int numberOfQueries = Integer.parseInt(input.nextLine());
		final String[] queries = new String[numberOfQueries];
		for (int i = 0; i < numberOfQueries; i++) {
			queries[i] = input.nextLine();			
		}
		int numberOfSwitches = 0;
		String searchEngineName = getOptimalSearchEngine(queries, searchEngineNames, 0);
		for (int i = 0; i < numberOfQueries; i++) {
			if (queries[i].equals(searchEngineName)) {
				searchEngineName = getOptimalSearchEngine(queries, searchEngineNames, i);
				numberOfSwitches++;
			}
			
		}
		return numberOfSwitches;
	}

	private String getOptimalSearchEngine(String[] queries, String[] searchEngineNames, int start) {
		Map<String, Integer> searchEngineIndexes = new HashMap<String, Integer>();
		for (int i = start; i < queries.length; i++) {
			if (!searchEngineIndexes.containsKey(queries[i])) {
				searchEngineIndexes.put(queries[i], i);
			}
		}
		int score = 0;
		String searchEngineName = null;
		for (int i = 0; i < searchEngineNames.length; i++) {
			if (searchEngineIndexes.containsKey(searchEngineNames[i])) {
				if (searchEngineIndexes.get(searchEngineNames[i]) > score) {
					searchEngineName = searchEngineNames[i];
					score = searchEngineIndexes.get(searchEngineNames[i]);
				}
			} else {
				return searchEngineNames[i];
			}
		}
		return searchEngineName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new SavingTheUniverse().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
