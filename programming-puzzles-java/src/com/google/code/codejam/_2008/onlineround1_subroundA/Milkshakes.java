/**
 * 
 */
package com.google.code.codejam._2008.onlineround1_subroundA;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class Milkshakes extends BaseCommandLineClient {
	private static final String IMPOSSIBLE = " IMPOSSIBLE";
	private static final int MALTED = 1;
	private static final int UNMALTED = 0;

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
		List<Flavor> flavours = new ArrayList<Flavor>(N);
		for (int i = 0; i < N; i++) {
			flavours.add(new Flavor(i + 1, 0));
		}
		List<List<Flavor>> customerFavorites = new ArrayList<List<Flavor>>(M);
		for (int i = 0; i < M; i++) {
			int T = input.nextInt();
			
			List<Flavor> favorites = new ArrayList<Flavor>(T);
			for (int j = 0; j < T; j++) {
				int X = input.nextInt();
				int Y = input.nextInt();
				Flavor flavor = new Flavor(X, Y);
				int index = flavours.indexOf(flavor);
				if (index > -1) {
					flavours.get(index).getCustomers().add(i);
				}
				favorites.add(flavor);				
			}
			customerFavorites.add(favorites);
		}
		for (List<Flavor> favorite : customerFavorites) {
			if (Collections.disjoint(favorite, flavours) ) {
				boolean satisfied = false;
				for (Flavor flavor : favorite) {
					if (tryChangingFlavors(flavours, flavor, customerFavorites)) {
						satisfied = true;
						break;
					}
				}
				if (!satisfied) {
					return IMPOSSIBLE;
				}
			}
		}
		
		return convertToString(flavours);
	}

	private String convertToString(List<Flavor> flavours) {
		StringBuilder builder = new StringBuilder();
		for (Flavor flavor : flavours) {
			builder.append(" ");
			builder.append(flavor.getMalted());
		}
		return builder.toString();
	}

	private boolean tryChangingFlavors(List<Flavor> flavours, Flavor flavor, List<List<Flavor>> customerFavorites) {
		Flavor oldFlavour = flavours.get(flavor.getFlavour() - 1);
		flavours.set(flavor.getFlavour() - 1, flavor);
		List<Integer> fans = oldFlavour.getCustomers();
		for (int fan : fans) {
			if (Collections.disjoint(customerFavorites.get(fan), flavours) ) {			
				flavours.set(flavor.getFlavour() - 1, oldFlavour);
				return false;
			}
		}
		
		return true;
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
