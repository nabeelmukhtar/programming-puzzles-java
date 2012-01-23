package com.google.code.facebook.hackercup._2012.qualificationround;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.code.facebook.hackercup.common.BaseCommandLineClient;

/**
package com.google.code.facebook.hackercup._2012.qualificationround;

import java.io.BufferedReader;

/**
 * @author nmukhtar
 *
 */
public class Auction extends BaseCommandLineClient {
	
	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int i = 0; i < T; i++) {
			String[] tokens = input.readLine().split(delimiter);
			long N = Long.parseLong(tokens[0]);
			long P1 = Long.parseLong(tokens[1]);
			long W1 = Long.parseLong(tokens[2]);
			long M = Long.parseLong(tokens[3]);
			long K = Long.parseLong(tokens[4]);
			long A = Long.parseLong(tokens[5]);
			long B = Long.parseLong(tokens[6]);
			long C = Long.parseLong(tokens[7]);
			long D = Long.parseLong(tokens[8]);
			Product[] products = new Product[(int)N];
			products[0] = new Product(P1, W1);
			for (long j = 1; j < products.length; j++) {
				long pj = ((A * products[(int) j - 1].getCost() + B) % M) + 1;
				long wj = ((C * products[(int) j - 1].getWeight() + D) % K) + 1;
				products[(int) j] = new Product(pj, wj);
			}
//			Arrays.sort(products);
			long terribleDeals = 0;
			long bargains = 0;
			for (long j = 0; j < products.length; j++) {
				boolean terrible = true;
				for (long k = 0; k < products.length; k++) {
					if (j != k) {
						if (products[(int) j].isBetterThan(products[(int) k])) {
							terrible = false;
							break;
						}
					}
				}
				if (terrible) {
					terribleDeals++;
				}
			}
			for (long j = 0; j < products.length; j++) {
				boolean bargain = true;
				for (long k = 0; k < products.length; k++) {
					if (j != k) {
						if (products[(int) k].isBetterThan(products[(int) j])) {
							bargain = false;
							break;
						}
					}
				}
				if (bargain) {
					bargains++;
				}
			}
			output.println("Case #" + (i + 1) + ": " + terribleDeals + " " + bargains);
		}
		output.flush();
	}
	
	private static class Product {
		long cost;
		long weight;
		
		Product(long cost, long weight) {
			this.cost = cost;
			this.weight = weight;
		}
		/**
		 * @return the cost
		 */
		public long getCost() {
			return cost;
		}
		/**
		 * @return the weight
		 */
		public long getWeight() {
			return weight;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Product [cost=" + cost + ", weight=" + weight + "]";
		}
		public boolean isBetterThan(Product other) {
			if ((getCost() < other.getCost() && getWeight() <= other.getWeight()) 
					|| (getCost() <= other.getCost() && getWeight() < other.getWeight())) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Auction().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
}
