package tictactoeNetwork;

import javax.swing.*;

public class TicTacToe {
	
	public final static int NUM_OF_ROWS = 3;
	public final static int NUM_OF_COLS = 3;
	public final static String CIRCLE = "O";
	public final static String CROSS = "X";
	
	public static void initBoard(String[][] board) {
		for (int i=0; i < NUM_OF_ROWS; i++) {
			for (int j=0; j < NUM_OF_COLS; j++) {
				board[i][j] = " ";
			}
		}
	}
	
	public static void win(String turn) {
		String msg;
		//System.out.println(turn + " Win !!! ");
		msg = turn + " Win !!!";
		JOptionPane.showMessageDialog(null, msg);
	}

	public static boolean checkWin(String[][] board, int rows, int cols, String turn, int row, int col) {

		// check row (---) e.g. first row: (0,0) (0,1) (0,2)
		for (int j=0; j < cols; j++) {
			if (!board[row][j].equals(turn)) {
					break;
			}
			if (j == cols-1) {
				return true;
			}
		}
			
		// check column (|) e.g. first column: (0,0) (1,0) (2,0)
		for (int i=0; i < rows; i++) {
			if (!board[i][col].equals(turn)) {
				break;
			}
			if (i == rows-1) {
				return true;
			}
		}
		
		// check diagonal (/) (0,0) (1,1) (2,2)
		if (row == col) {
			for (int i=0; i < rows; i++) {
				if (!board[i][i].equals(turn)) {
					break;
				}
				if (i == cols-1) {
					return true;
				}
			}
		}
		
		// check diagnoal (\) (2,0) (1,1) (0,2)
		if ((row + col) == (rows-1)) {
			for (int i=rows-1; i >= 0; i--) {
				if (!board[i][(rows-1-i)].equals(turn)) {
					break;
				}
				if (i == 0) {
					return true;
				}
			}
		}
				
		return false;
	}
	
	public static void tie() {
		String msg = "Draw !!!";
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static boolean checkTie(int count, int rows, int cols) {
		System.out.println("count = " + count);
		if (count == rows * cols) {
			return true;
		}
		return false;
	}

}
