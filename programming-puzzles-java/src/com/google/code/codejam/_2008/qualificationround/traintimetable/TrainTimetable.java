/**
 * 
 */
package com.google.code.codejam._2008.qualificationround.traintimetable;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

import com.google.code.codejam.common.BaseCommandLineClient;

/**
 * @author nmukhtar
 *
 */
public class TrainTimetable extends BaseCommandLineClient {

	/**
	 */
	@Override
	public void process(BufferedReader input, PrintWriter output) throws Exception {
		final int numberOfTestCases = Integer.parseInt(input.readLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			handleTestCase(i, input, output);			
		}
		output.flush();
	}

	private void handleTestCase(int number, BufferedReader input, PrintWriter output) throws Exception {
		int turnaroundTime = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(delimiter);
		int tripsFromA = Integer.parseInt(tokens[0]);
		Time[] aDepartures = new Time[tripsFromA];
		Time[] aArrivals = new Time[tripsFromA];
		int tripsFromB = Integer.parseInt(tokens[1]);
		Time[] bDepartures = new Time[tripsFromB];
		Time[] bArrivals = new Time[tripsFromB];
		for (int i = 0; i < tripsFromA; i++) {
			String[] times = input.readLine().split(delimiter);
			aDepartures[i] = Time.parse(times[0]);
			aArrivals[i] = Time.parse(times[1]);
		}
		for (int i = 0; i < tripsFromB; i++) {
			String[] times = input.readLine().split(delimiter);
			bDepartures[i] = Time.parse(times[0]);
			bArrivals[i] = Time.parse(times[1]);
		}
		int trainsA = 0;
		int trainsB = 0;
		Arrays.sort(aDepartures);
		Arrays.sort(bArrivals);
		int count = 0;
		for (int i = 0; i < tripsFromA; i++) {
			boolean trainFound = false;
			for (int j = count; j < tripsFromB; j++) {
				if (aDepartures[i].differenceInMinutes(bArrivals[j]) >= turnaroundTime) {
					trainFound = true;
					count = j + 1;
					break;
				}
			}
			if (!trainFound) {
				trainsA++;
			}
		}
		
		Arrays.sort(bDepartures);
		Arrays.sort(aArrivals);
		count = 0;
		for (int i = 0; i < tripsFromB; i++) {
			boolean trainFound = false;
			for (int j = count; j < tripsFromA; j++) {
				if (bDepartures[i].differenceInMinutes(aArrivals[j]) >= turnaroundTime) {
					trainFound = true;
					count = j + 1;
					break;
				}
			}
			if (!trainFound) {
				trainsB++;
			}
		}
		
		output.println(String.format("Case #%d: %d %d", number + 1, Math.max(trainsA, 0), Math.max(trainsB, 0)));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
            new TrainTimetable().run(args);
            System.exit(0);
    	} catch (Throwable t) {
    		t.printStackTrace();
    		System.exit(1);
    	}
	}
	
	private static class Time implements Comparable<Time> {
		private int hours;
		private int minutes;
		
		public Time(int hours, int minutes) {
			this.hours = hours;
			this.minutes = minutes;
		}
		/**
		 * @return the hours
		 */
		public int getHours() {
			return hours;
		}
		/**
		 * @param hours the hours to set
		 */
		public void setHours(int hours) {
			this.hours = hours;
		}
		/**
		 * @return the minutes
		 */
		public int getMinutes() {
			return minutes;
		}
		/**
		 * @param minutes the minutes to set
		 */
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}
		
		public void addMinutes(int minutes) {
			this.minutes += minutes;
			int diff = this.minutes - 60;
			if (diff > 0) {			
				this.hours += diff / 60;
				this.minutes = diff % 60;
			}
		}
		
		public int differenceInMinutes(Time other) {
			int difference = (this.getHours() - other.getHours()) * 60;
			difference += this.getMinutes() - other.getMinutes();
			return difference;
		}
		
		public static Time parse(String input) {
			String[] tokens = input.split(":");
			return new Time(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		
		@Override
		public int compareTo(Time o) {
			return (this.getHours() * 60 + this.getMinutes()) - (o.getHours() * 60 + o.getMinutes());			
		}

		@Override
		public String toString() {
			return "Time [hours=" + hours + ", minutes=" + minutes + "]";
		}
	}
}
