package com.wityo.dynamicprogramming.multistagegraph;

public class MultiStageDriver {
	private static final int INF = Integer.MAX_VALUE;

	public static int shortestDistance(int[][] graph) {
		int n = graph.length + 1;
		int distance[] = new int[graph.length + 1];
		distance[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			distance[i] = INF;
			for (int j = i+1; j < n; j++) {
				if (graph[i][j] == INF)
					continue;
				distance[i] = Math.min(distance[i], graph[i][j] + distance[j]);
			}
		}
		return distance[0];
	}

	public static void main(String[] args) {
		int[][] graph = { { INF, 9, 7, 3, 2, INF, INF, INF, INF, INF, INF, INF }, // 0
				{ INF, INF, INF, INF, INF, 4, 2, INF, INF, INF, INF, INF }, // 1
				{ INF, INF, INF, INF, INF, 2, 7, INF, INF, INF, INF, INF }, // 2
				{ INF, INF, INF, INF, INF, INF, INF, 11, INF, INF, INF, INF }, // 3
				{ INF, INF, INF, INF, INF, INF, 11, 8, INF, INF, INF, INF }, // 4
				{ INF, INF, INF, INF, INF, INF, INF, INF, 6, 5, INF, INF }, // 5
				{ INF, INF, INF, INF, INF, INF, INF, INF, 4, 3, INF, INF }, // 6
				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, 5, 6, INF }, // 7
				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 9 }, // 8
				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 2 }, // 9
				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5 }, // 10
		};
		
		System.out.println(shortestDistance(graph));
	}

}
