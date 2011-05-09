package com.google.code.codejam._2011.qualificationround;
/**
 * 
 */
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 * 
 */
public class Magicka extends BaseCommandLineClient {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new Magicka().run(args);
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
			output.printf("Case #%d: %s\n", i, getElementList(input));			
		}
	}

	private List<Character> getElementList(Scanner input) {
		String[] tokens = input.nextLine().split(delimiter);
		List<Character> elementList = new ArrayList<Character>();
		Map<Pair<Character>, Character> conversionMap = new HashMap<Pair<Character>, Character>();
		Map<Character, Character> eliminationMap = new HashMap<Character, Character>();
		int index = 0;
		int C = Integer.parseInt(tokens[index++]);
		for (int i = 0; i < C; i++) {
			String sequence = tokens[index++];
			Pair<Character> key = new Pair<Character>(sequence.charAt(0), sequence.charAt(1));
			Character value = sequence.charAt(2);
			conversionMap.put(key, value);
			key = new Pair<Character>(sequence.charAt(1), sequence.charAt(0));
			conversionMap.put(key, value);
		}
		int D = Integer.parseInt(tokens[index++]);
		for (int i = 0; i < D; i++) {
			String sequence = tokens[index++];
			Character key = sequence.charAt(0);
			Character value = sequence.charAt(1);
			eliminationMap.put(key, value);
			eliminationMap.put(value, key);
		}
		int N = Integer.parseInt(tokens[index++]);
		String sequence = tokens[index++];
		for (int i = 0; i < N; i++) {
			Character c = sequence.charAt(i);
			if (!elementList.isEmpty() && conversionMap.containsKey(new Pair<Character>(c, elementList.get(elementList.size() - 1)))) {
				elementList.set(elementList.size() - 1, conversionMap.get(new Pair<Character>(c, elementList.get(elementList.size() - 1))));
			} else if (!elementList.isEmpty() && eliminationMap.containsKey(c) && elementList.contains(eliminationMap.get(c))) {
				elementList.clear();
			} else {
				elementList.add(c);
			}
		}
		return elementList;
	}
	
	public static class Pair<T> {
		private T first;
		private T second;
		
		public Pair(T first, T second) {
			super();
			this.first = first;
			this.second = second;
		}
		/**
		 * @return the first
		 */
		public T getFirst() {
			return first;
		}
		/**
		 * @param first the first to set
		 */
		public void setFirst(T first) {
			this.first = first;
		}
		/**
		 * @return the second
		 */
		public T getSecond() {
			return second;
		}
		/**
		 * @param second the second to set
		 */
		public void setSecond(T second) {
			this.second = second;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((first == null) ? 0 : first.hashCode());
			result = prime * result
					+ ((second == null) ? 0 : second.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Pair<?> other = (Pair<?>) obj;
			if (first == null) {
				if (other.first != null)
					return false;
			} else if (!first.equals(other.first))
				return false;
			if (second == null) {
				if (other.second != null)
					return false;
			} else if (!second.equals(other.second))
				return false;
			return true;
		}
	}
}
