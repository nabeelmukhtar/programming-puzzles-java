package com.google.code.codejam._2010.qualificationround;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

/**
 * @author nmukhtar
 * 
 */
public class ThemePark {
	protected String delimiter = "\\s";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new ThemePark().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}

	/**
	 * @param args
	 */
	protected void run(String[] args) {
		if (args.length < 1) {
			printHelp();
		} else {
			BufferedReader reader = null;
			PrintWriter writer = null;
			try {
				reader = new BufferedReader(new FileReader(args[0]));
				if (args.length > 1) {
					writer = new PrintWriter(new FileWriter(args[1]));
					process(new Scanner(reader), writer);
				} else {
					process(new Scanner(reader), new PrintWriter(System.out, true));
				}
			} catch (Exception e) {
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
		System.out
				.println("The syntax to run this command line application is:");
		System.out.println("java " + getClass().getName()
				+ " <inputfilename> [<outputfilename>]");
		System.out.println("If you do not specify an output file name, output will be printed on the console.");
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
	 * @param input TODO
	 * @param output TODO
	 * @throws Exception TODO
	 * 
	 */
	public void process(Scanner input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= T; i++) {
			output.printf("Case #%d: %d\n", i, getNumberOfEuros(input));			
		}
	}

	private long getNumberOfEuros(Scanner input) {
		String[] tokens = input.nextLine().split(delimiter);
		long R = Long.parseLong(tokens[0]);
		long k = Long.parseLong(tokens[1]);
		int N = Integer.parseInt(tokens[2]);
		long[] queue = new long[N];
		tokens = input.nextLine().split(delimiter);
		for (int i = 0; i < N; i++) {
			queue[i] = Integer.parseInt(tokens[i]);
		}
		long eurosEarned = 0;
		for (int i = 0; i < R; i++) {
			long currentCapacity = 0;
			int fitIndex = 0;
			while (fitIndex < queue.length && (queue[fitIndex] + currentCapacity) <= k) {
				currentCapacity += queue[fitIndex];
				fitIndex++;
			}
			eurosEarned += currentCapacity;
			rotateQueue(queue, fitIndex);
		}
		return eurosEarned;
	}

	private void rotateQueue(long[] queue, int fitIndex) {
		long[] temp = new long[fitIndex];
		for (int i = 0; i < queue.length; i++) {
			if (i < fitIndex) {			
				temp[i] = queue[i];
			} else {
				queue[i - fitIndex] = queue[i];
			}
		}
		int count = 0;
		for (int i = queue.length - fitIndex; i < queue.length; i++) {
			queue[i] = temp[count++];
		}
	}
}
