package com.wityo.greedy.jobsequencing;

/**
 * @author Akash Beura
 *
 */

class Job {

	public Job(String jobName, int deadLine, int profit) {
		super();
		this.jobName = jobName;
		this.deadLine = deadLine;
		this.profit = profit;
	}

	private String jobName;
	private int deadLine;
	private int profit;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

}

public class JobSequencingDriver {

	/* Method to sort the jobs based on their profit */
	public void sortOnProfit(Job arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].getProfit() < arr[j + 1].getProfit()) {
					Job temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/*
	 * Method to find the maxDeadline so that we can assume the size of resultant
	 * array
	 */
	public int findMaxDeadline(Job a[]) {
		int max = -1;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i].getDeadLine()) {
				max = a[i].getDeadLine();
			}
		}
		return max;
	}

	/* Method which find out the sequencing */
	public Job[] findJobSequence(Job arr[]) {
		int n = arr.length;
		// First sort it based on profit.
		sortOnProfit(arr);
		// Find the max deadline to get the size of resultant array
		int maxDeadLine = findMaxDeadline(arr);
		Job result[] = new Job[maxDeadLine];

		// Allocate the max profit job to the farthest slot possible
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].getDeadLine() - 1; j >= 0; j--) {
				if (result[j] == null) {
					result[j] = arr[i];
					break;
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		Job j1 = new Job("a", 4, 20);
		Job j2 = new Job("b", 1, 10);
		Job j3 = new Job("c", 1, 40);
		Job j4 = new Job("d", 1, 30);
		Job[] jobs = { j1, j2, j3, j4 };
		Job[] result = new JobSequencingDriver().findJobSequence(jobs);

		// Printing the sequence
		for (int i = 0; i < result.length; i++) {
			if (result[i] != null)
				System.out.println(result[i].getJobName());
		}

	}

}
