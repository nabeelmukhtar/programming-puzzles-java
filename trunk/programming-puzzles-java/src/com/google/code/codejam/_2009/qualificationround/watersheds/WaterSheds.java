/**
 * 
 */
package com.google.code.codejam._2009.qualificationround.watersheds;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class WaterSheds extends BaseCommandLineClient {
	private int numberOfMaps;
	private int heightOfMap;
	private int widthOfMap;
	private int counter;
	private int[][] map;
	private Map<Coordinate, Character> labels = new HashMap<Coordinate, Character>();
	

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		String line = null;
		int lineNumber = 1;
		while ((line = input.readLine()) != null) {
			String[] lineTokens = line.split(delimiter);
			if (lineNumber == 1) {
				numberOfMaps = Integer.parseInt(lineTokens[0]);
			} else if (heightOfMap == 0 && widthOfMap == 0) {
				heightOfMap = Integer.parseInt(lineTokens[0]);
				widthOfMap = Integer.parseInt(lineTokens[1]);
				map = new int[heightOfMap][widthOfMap];
			} else if (counter < heightOfMap) {
				for (int i = 0; i < widthOfMap; i++) {
					map[counter][i] = Integer.parseInt(lineTokens[i]);
				}
				counter++;
			} else {
				printSinks();
				heightOfMap = 0;
				widthOfMap = 0;
				map = null;
				labels.clear();
			}
			lineNumber++;
		}
	}

	private void printSinks() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new WaterSheds().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
	
	static class Coordinate {
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
