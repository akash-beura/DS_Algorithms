package com.wityo.backtracking;

public class Sudoku {

// choice constraints goal

	// constaing
	public boolean checkValidity(int row, int col, int value, int[][] board) {
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == value) {
				return false;
			}
		}
		for (int j = 0; j < board.length; j++) {
			if (board[j][col] == value) {
				return false;
			}
		}

		int subBoxSize = (int) Math.sqrt(board.length);
		int startRow = row - row % subBoxSize;
		int startCol = col - col % subBoxSize;
		for (int i = startRow; i < startRow + subBoxSize; i++) {
			for (int j = startCol; j < startCol + subBoxSize; j++) {
				if (board[i][j] == value)
					return false;
			}
		}
		return true;
	}

	// choice
	public boolean solveSudoku(int row, int col, int[][] board) {

		// if 1 row is done, move to another row
		if (col == board[row].length) {
			row = row + 1;
		}

		// 1. Finalize your choice
		for (int i = 1; i <= board.length; i++) {
			if (checkValidity(row, col, i, board)) {
				board[row][col] = i;
				if (solveSudoku(row, col + 1, board)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
}
