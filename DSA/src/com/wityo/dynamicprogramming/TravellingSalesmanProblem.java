package com.wityo.dynamicprogramming;

public class TravellingSalesmanProblem {

	public int[] getNewRemaining(int[] a, int k) {
		if (a.length - 1 == 0)
			return null;
		int[] temp = new int[a.length - 1];

		int p = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != k) {
				temp[p++] = a[i];
			}
		}
		return temp;
	}

	public int tsp(int[][] graph, int src, int[] remainingNodes) {
		if (remainingNodes == null) {
			return graph[src][0];
		}
		int cost[] = new int[remainingNodes.length];
		for (int i = 0; i < remainingNodes.length; i++) {
			int nextSource = remainingNodes[i];
			int[] newRemainingNodes = getNewRemaining(remainingNodes, nextSource);
			cost[i] = graph[src][nextSource] + tsp(graph, nextSource, newRemainingNodes);
		}
		int finalCost = Integer.MAX_VALUE;
		for (int i = 0; i < cost.length; i++) {
			finalCost = Math.min(finalCost, cost[i]);
		}
		return finalCost;
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 10, 15, 20 }, { 5, 0, 9, 10 }, { 6, 13, 0, 12 }, { 8, 8, 9, 0 } };
		int remaining[] = { 1, 2, 3 };
		System.out.println(new TravellingSalesmanProblem().tsp(graph, 0, remaining));
	}

}
