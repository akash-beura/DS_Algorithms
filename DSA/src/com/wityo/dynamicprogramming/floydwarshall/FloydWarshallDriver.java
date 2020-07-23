package com.wityo.dynamicprogramming.floydwarshall;

public class FloydWarshallDriver {

	public static int[][] findMultiSourceShortestPath(int[][] graph) {
		int n = graph.length;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (j == k || i == j)
						continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		return graph;
	}

	public static void main(String[] args) {
		final int INF = 1000000;
		int[][] graph = { { 0, 3, INF, 7 }, { 8, 0, 2, INF }, { 5, INF, 0, 1 }, { 2, INF, INF, 0 } };
		graph = findMultiSourceShortestPath(graph);
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
