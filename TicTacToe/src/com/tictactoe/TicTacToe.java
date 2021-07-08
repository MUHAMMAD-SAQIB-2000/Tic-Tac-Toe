package com.tictactoe;

@SuppressWarnings("unused")
public class TicTacToe {

	private String[][] board;

	public TicTacToe(String[][] board) {
		this.board = board;
	}

	public void printBoard() {
		System.out.println("---------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("---------");
	}

	public String checkBoard() {

		String result = "";
		String winner = "";

		boolean didXWin = false;
		boolean didOWin = false;

		
		String gameNotFinished = "Game not finished";
		String impossible = "Impossible";
		String draw = "Draw";

		boolean getXandOCount = getXandOCount();
		boolean checkEmptyCells = checkEmptyCells();
		String horizontalX = checkHorizontal("X");
		String verticalX = checkVertical("X");
		String diagonalX = checkDiagonal("X");

		if (!horizontalX.equals("") || !verticalX.equals("") || !diagonalX.equals("")) {
			didXWin = true;
			winner = "X wins";
		}

//		System.out.println(horizontalX + ", " + verticalX + ", " + diagonalX);

		String horizontalO = checkHorizontal("O");
		String verticalO = checkVertical("O");
		String diagonalO = checkDiagonal("O");

//		System.out.println(horizontalO + ", " + verticalO + ", " + diagonalO);

		if (!horizontalO.equals("") || !verticalO.equals("") || !diagonalO.equals("") && diagonalX.equals("")) {
			didOWin = true;
			winner = "O wins";
		}

		if (didXWin == false && didOWin == false && checkEmptyCells == false) {
			result = draw;
			return result;
		} else if(didXWin == true || didOWin == true) {
			result = winner;
			return result;
		} else {
			return "";
		}
	}

	public Boolean checkEmptyCells() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				String cell = board[i][j];
				if (cell.equals("_") || cell.equals("")) {
					return true;
				}
			}
		}
		return false;
	}

	public String checkDiagonal(String choice) {
		String result = "";
		String cell1 = "";
		String cell2 = "";
		String cell3 = "";
		String cell4 = "";
		String cell5 = "";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				cell1 = board[i][j];
				cell2 = board[i + 1][j + 1];
				cell3 = board[i + 2][j + 2];
				cell4 = board[i][j + 2];
				cell5 = board[i + 2][j];

//				System.out.println(cell1+", " +cell2+", "+cell3+", "+cell4+", "+cell5+", ");
				if (cell1.equals(choice) && cell2.equals(choice) && cell3.equals(choice)) {
//					System.out.println("1, ");
					result = choice;
				} else if (cell4.equals(choice) && cell2.equals(choice) && cell5.equals(choice)) {
					result = choice;
//					System.out.println("2, ");
				}
			}
		}
		return result;
	}

	public String checkHorizontal(String choice) {
		String win = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < 1; j++) {
				String cell1 = board[i][j];
				String cell2 = board[i][j + 1];
				String cell3 = board[i][j + 2];
				if (cell1.equals(choice) && cell2.equals(choice) && cell3.equals(choice)) {
					win = choice;
				}
			}
		}
		return win;
	}

	public String checkVertical(String choice) {
		String win = "";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < board.length; j++) {
				String cell1 = board[i][j];
				String cell2 = board[i + 1][j];
				String cell3 = board[i + 2][j];
				if (cell1.equals(choice) && cell2.equals(choice) && cell3.equals(choice)) {
					win = choice;
				}
			}
		}
		return win;
	}

	public Boolean getXandOCount() {
		int countX = 0;
		int countO = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				String cell = board[i][j];
				if (cell.equals("X")) {
					countX++;
				} else if (cell.equals("O")) {
					countO++;
				}
			}
		}
		int diff = countX - countO;
		diff = diff < 0 ? diff * -1 : diff;
		boolean result = diff >= 2 ? true : false;
		return result;
	}

	public boolean checkIfSlotFreeToAddValue(int num1, int num2, String input) {
		String cell = board[num1][num2];
		if (cell.equals("") || cell.equals("_")) {
			board[num1][num2] = input;
			return true;
		} else {
			return false;
		}
	}
}

/*
 *  else if (didXWin == true && didOWin == true && checkEmptyCells == true) {
			result = impossible;
			return result;
		} else if (getXandOCount == true) {
			result = impossible;
			return result;
		}*/
