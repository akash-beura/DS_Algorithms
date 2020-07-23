package com.wityo.backtracking;

public class ShortestPathMaze {

	public int shortestPath(int a[][], int startX, int startY, int destX, int destY) {

		boolean[][] visited = new boolean[a.length][a[0].length];
		return shortestPath(a, startX, startY, destX, destY, visited);

	}

	public int shortestPath(int a[][], int i, int j, int x, int y, boolean[][] visited) {

		// 2. base case (a), when we reach our destination, return 0;
		if (i == x && j == y) {
			return 0;
		}
		// 2. base case(b)
		if (!isValid(a, i, j, x, y, visited)) {
			return 99999;
		}

		// when you visit this location mark it as true so that when comparing next you
		// dont count this again
		visited[i][j] = true;
		// go to paths top, left,right, bot and minimum will be the answer.

		int left = shortestPath(a, i, j - 1, x, y, visited) + 1;
		int top = shortestPath(a, i - 1, j, x, y, visited) + 1;
		int right = shortestPath(a, i, j + 1, x, y, visited) + 1;
		int bot = shortestPath(a, i + 1, j, x, y, visited) + 1;

		// when returning mark it as false.
		visited[i][j] = false;
		int result = Math.min(Math.min(left, right), Math.min(top, bot));
//		System.out.println("Result at I=" + i + " J=" + j + " == " + result);
		return result;

	}

	// 1. check for validation
	public boolean isValid(int a[][], int i, int j, int x, int y, boolean[][] visited) {
		int rows = a.length;
		int cols = a[0].length;
		return i >= 0 && j >= 0 && i < rows && j < cols && a[i][j] != 0 && !visited[i][j];
	}

	public static void main(String[] args) {
		int[][] a = { 
				{ 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 } };

		System.out.println(new ShortestPathMaze().shortestPath(a, 0, 0, 2, 4));
	}
}
