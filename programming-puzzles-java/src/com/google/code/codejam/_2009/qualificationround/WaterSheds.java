/**
 * 
 */
package com.google.code.codejam._2009.qualificationround;

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
	

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		int numberOfMaps = 0;
		int heightOfMap = 0;
		int widthOfMap = 0;
		int counter = 0;
		int[][] map = null;
		int testNumber = 1;
		
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
			} else {
				if (counter < heightOfMap) {
					for (int i = 0; i < widthOfMap; i++) {
						map[counter][i] = Integer.parseInt(lineTokens[i]);
					}
					counter++;
				}
				if (counter == heightOfMap) {
					output.println(String.format("Case #%d:", testNumber));
					printSinks(map, output);
					heightOfMap = 0;
					widthOfMap = 0;
					counter = 0;
					testNumber++;
					map = null;
				}
			}
			lineNumber++;
		}
	}

	private void printSinks(int[][] map, PrintWriter output) {
		Map<Coordinate, Character> labels = new HashMap<Coordinate, Character>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Coordinate sink = getSink(map, new Coordinate(i, j));
				if (labels.containsKey(sink)) {
					output.print(labels.get(sink));										
				} else {
					Character label = getNextLabel(labels);
					labels.put(sink, label);
					output.print(label);
				}
				if (j != map[i].length - 1) {
					output.print(" ");
				} else {
					output.println();
				}
			}
		}
		output.flush();
	}

	private Character getNextLabel(Map<Coordinate, Character> labels) {
		if (labels.isEmpty()) {
			return 'a';
		} else {
			char max = 0; 
			for (Character c : labels.values()) {
				if (c.charValue() > max) {
					max = c.charValue();
				}
			}
			return (char) (max + 1);
		}
	}

	private Coordinate getSink(int[][] map, Coordinate loc) {
		int minAltitude = map[loc.getX()][loc.getY()];
		Coordinate sink = loc;
		if (loc.getX() - 1 >= 0 && map[loc.getX() - 1][loc.getY()] < minAltitude) {
			minAltitude = map[loc.getX() - 1][loc.getY()];
			sink = new Coordinate(loc.getX() - 1, loc.getY());
		}
		if (loc.getY() - 1 >= 0 && map[loc.getX()][loc.getY() - 1] < minAltitude) {
			minAltitude = map[loc.getX()][loc.getY() - 1];
			sink = new Coordinate(loc.getX(), loc.getY() - 1);
		}
		if (loc.getY() + 1 < map[loc.getX()].length && map[loc.getX()][loc.getY() + 1] < minAltitude) {
			minAltitude = map[loc.getX()][loc.getY() + 1];
			sink = new Coordinate(loc.getX(), loc.getY() + 1);
		}
		if (loc.getX() + 1 < map.length && map[loc.getX() + 1][loc.getY()] < minAltitude) {
			minAltitude = map[loc.getX() + 1][loc.getY()];
			sink = new Coordinate(loc.getX() + 1, loc.getY());
		}
		if (sink.equals(loc)) {
			return sink;
		} else {
			return getSink(map, sink);
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
