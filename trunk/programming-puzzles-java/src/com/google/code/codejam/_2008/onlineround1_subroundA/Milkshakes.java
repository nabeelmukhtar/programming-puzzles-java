/**
 * 
 */
package com.google.code.codejam._2008.onlineround1_subroundA;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Milkshakes extends BaseCommandLineClient {
	private static final String IMPOSSIBLE = " IMPOSSIBLE";

	/**
	 */
	@Override
	public void process(Scanner input, PrintWriter output) throws Exception {
		int C = input.nextInt();
		for (int i = 0; i < C; i++) {
			output.printf("Case #%d:%s\n", (i + 1), prepareMilkShakes(input));
		}
	}

	private String prepareMilkShakes(Scanner input) {
		int N = input.nextInt();
		int M = input.nextInt();
		
		int[] T = new int[M];
		int[][] X = new int[M][];
		int[][] Y = new int[M][];
		for ( int i = 0; i < M; i ++ ) {
			T[i] = input.nextInt();
			X[i] = new int[T[i]];
			Y[i] = new int[T[i]];
			for ( int j = 0; j < T[i]; j ++ ) {
				X[i][j] = input.nextInt() - 1;
				Y[i][j] = input.nextInt();
			}
		}
		int[] r = new int[N];
		boolean possible = true;
		for ( int i = 0; i < N; i ++ ) {
			for ( int j = 0; j < M; j ++ ) {
				boolean ok = false;
				for ( int k = 0; k < T[j]; k ++ ) {
					if ( r[X[j][k]] == Y[j][k] ) {
						ok = true;
						break;
					}
				}
				if ( !ok ) {
					for ( int k = 0; k < T[j]; k ++ ) {
						if ( Y[j][k] == 1 ) {
							ok = true;
							r[X[j][k]] = 1;
						}
					}
					if ( !ok ) {
						possible = false;
						break;
					}
				}
			}
		}
		if ( !possible ) {
			return IMPOSSIBLE;
		} else {
			return convertToString(r);
		}
	}

	private String convertToString(int[] r) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < r.length; i++) {
			builder.append(" ");
			builder.append(r[i]);
		}
		return builder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Milkshakes().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
	
	private static class Flavor {
		private int flavour;
		private int malted;
		private List<Integer> customers = new ArrayList<Integer>();
		
		public Flavor(int flavour, int malted) {
			super();
			this.flavour = flavour;
			this.malted = malted;
		}
		/**
		 * @return the flavour
		 */
		public int getFlavour() {
			return flavour;
		}
		/**
		 * @param flavour the flavour to set
		 */
		public void setFlavour(int flavour) {
			this.flavour = flavour;
		}
		/**
		 * @return the malted
		 */
		public int getMalted() {
			return malted;
		}
		/**
		 * @param malted the malted to set
		 */
		public void setMalted(int malted) {
			this.malted = malted;
		}
		
		/**
		 * @return the cusomers
		 */
		public List<Integer> getCustomers() {
			return customers;
		}
		/**
		 * @param cusomers the cusomers to set
		 */
		public void setCustomers(List<Integer> customers) {
			this.customers = customers;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + flavour;
			result = prime * result + malted;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Flavor other = (Flavor) obj;
			if (flavour != other.flavour)
				return false;
			if (malted != other.malted)
				return false;
			return true;
		}
		
		
	}
}
