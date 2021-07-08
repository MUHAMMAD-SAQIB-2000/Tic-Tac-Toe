package com.main;

import java.util.Scanner;

import com.tictactoe.TicTacToe;

public class Main {

	static Scanner scan;

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		scan = new Scanner(System.in);
		String coordinates = "";

		String[][] board = new String[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = "_";
			}
		}
		TicTacToe game = new TicTacToe(board);
		game.printBoard();

		int num1 = 0;
		int num2 = 0;
		boolean isValueAdded = false;
		boolean keepRunning = true;
		int counter = 0 ;
		String player = "X";
		
		while (keepRunning) {
			System.out.println("Player "+ player+" Enter the coordinates: ");
			coordinates = scan.nextLine().trim();
			String[] coordinate = coordinates.split(" ");

			if (coordinate[0].length() > 1 || coordinate[0].length() > 1) {
				if (Character.isAlphabetic(coordinate[0].charAt(0))) {
					System.out.println("You should enter numbers!");
				}
			} else {
				num1 = Integer.parseInt(coordinate[0]);
				num2 = Integer.parseInt(coordinate[1]);
				if (num1 > 3 || num2 > 3) {
					System.out.println("Coordinates should be from 1 to 3!");
				} else {
					if(counter % 2 == 0) {
						isValueAdded = game.checkIfSlotFreeToAddValue(--num1, --num2, "X");						
						player = "O";
					} else {
						player = "X";
						isValueAdded = game.checkIfSlotFreeToAddValue(--num1, --num2, "O");												
					}
					if (isValueAdded) {
						game.printBoard();
						counter++;
					} else {
						System.out.println("This cell is occupied! Choose another one!");
					}
				}
			}
			String result = game.checkBoard();
			if (!result.equals("")) {
				System.out.println(result);
				keepRunning = false;
			}
		}

	}

}
