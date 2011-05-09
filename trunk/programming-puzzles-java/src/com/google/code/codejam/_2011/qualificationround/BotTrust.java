package com.google.code.codejam._2011.qualificationround;
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
public class BotTrust extends BaseCommandLineClient {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new BotTrust().run(args);
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
		int T = Integer.parseInt(input.nextLine());
		for(int i = 1; i <= T; i++) {
			output.printf("Case #%d: %d\n", i, getTimeTakenForSequence(input));			
		}
	}

	private int getTimeTakenForSequence(Scanner input) {
		String[] tokens = input.nextLine().split(delimiter);
		int N = Integer.parseInt(tokens[0]);
		int[] O = new int[N];
		int[] B = new int[N];
		for (int i = 1; i <= N; i++) {
			String robot = tokens[2 * i - 1];
			int button = Integer.parseInt(tokens[2 * i]);
			if ("O".equals(robot)) {
				O[i - 1] = button;
			} else {
				B[i - 1] = button;
			}
		}
		int oPosition = 1;
		int bPosition = 1;
		int time = 0;
		for (int i = 0; i < N; i++) {
			boolean buttonPressed = false;
			while (!buttonPressed) {
				if (O[i] == 0) {
					int bButton = B[i];
					int oButton = getNextButton(O, i);
					while (bPosition != bButton) {
						time++;
						bPosition = (bPosition < bButton)? (bPosition + 1) : (bPosition - 1);
						if (oPosition < oButton) {
							oPosition++;
						} else if (oPosition > oButton) {
							oPosition--;
						}
					}
					time++;
					buttonPressed = true;
					if (oPosition < oButton) {
						oPosition++;
					} else if (oPosition > oButton) {
						oPosition--;
					}
				} else {
					int bButton = getNextButton(B, i);
					int oButton = O[i];
					while (oPosition != oButton) {
						time++;
						oPosition = (oPosition < oButton)? (oPosition + 1) : (oPosition - 1);
						if (bPosition < bButton) {
							bPosition++;
						} else if (bPosition > bButton) {
							bPosition--;
						}
					}
					time++;
					buttonPressed = true;
					if (bPosition < bButton) {
						bPosition++;
					} else if (bPosition > bButton) {
						bPosition--;
					}
				}
			}
		}
		return time;
	}

	private int getNextButton(int[] o, int start) {
		for (int i = start; i < o.length; i++) {
			if (o[i] != 0) {
				return o[i];
			}
		}
		return 0;
	}
}
