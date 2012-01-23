/**
 * 
 */
package com.google.code.facebook.hackercup._2012.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class AlphabetSoup extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int i = 0; i < T; i++) {
			int[] times = new int["HACKERCUP".length()];
			String s = input.readLine();
			boolean cFlag = true;
			for (int j = 0; j < s.length(); j++) {
				switch (s.charAt(j)) {
				case 'H':
					times[0]++;
					break;
				case 'A':
					times[1]++;
					break;
				case 'C': {
					if (cFlag) {
						times[2]++;
					} else {
						times[6]++;
					}
					cFlag = !cFlag;
					break;
				}
				case 'K':
					times[3]++;
					break;
				case 'E':
					times[4]++;
					break;
				case 'R':
					times[5]++;
					break;
				case 'U':
					times[7]++;
					break;
				case 'P':
					times[8]++;
					break;
				default:
					break;
				}
			}
			Arrays.sort(times);
			output.println("Case #" + (i + 1) + ": " + times[0]);
		}
		output.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new AlphabetSoup().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
