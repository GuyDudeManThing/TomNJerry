//Samuel Garcia, Christian Bonilla
//Fall 2018
//Programming assignment 8

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Scanner;


public class MouseRace2  extends JFrame {
	
	// This part of the program is where the mouse and cheese starts on the maze. 
	// Calls back gameWon to end the loop and the initial score.
	// Also, tells the program how big the maze is when it's created.
	private int mouseRow = 1, mouseCol = 1;
	private int cheeseRow = 10, cheeseCol = 10;
	private int catRow = 9, catCol = 4;
	private int score = 0;
	private String[][] maze = new String[12][12];
	private boolean gameWon = false;

	
	MouseRace2() {
		// This prints out the welcome message when the program starts
		System.out.println("**************************************");
		System.out.println("*** WELCOME TO THE MOUSE RACE GAME ***");
		System.out.print("**************************************");
		
		// This part of the program shows where the blank spots where the mouse can move during the program
		maze[1][1] = "free";
		maze[2][1] = "free";
		maze[10][1] = "free";
		maze[2][2] = "free";
		maze[9][2] = "free";
		maze[10][2] = "free";
		maze[2][3] = "free";
		maze[3][3] = "free";
		maze[4][3] = "free";
		maze[5][3] = "free";
		maze[6][3] = "free";
		maze[9][3] = "free";
		maze[1][4] = "free";
		maze[2][4] = "free";
		maze[6][4] = "free";
		maze[8][4] = "free";
		maze[9][4] = "free";
		maze[1][5] = "free";
		maze[6][5] = "free";
		maze[8][5] = "free";
		maze[9][5] = "free";
		maze[1][6] = "free";
		maze[3][6] = "free";
		maze[4][6] = "free";
		maze[6][6] = "free";
		maze[9][6] = "free";
		maze[1][7] = "free";
		maze[4][7] = "free";
		maze[6][7] = "free";
		maze[9][7] = "free";
		maze[1][8] = "free";
		maze[2][8] = "free";
		maze[4][8] = "free";
		maze[6][8] = "free";
		maze[9][8] = "free";
		maze[2][9] = "free";
		maze[4][9] = "free";
		maze[6][9] = "free";
		maze[7][9] = "free";
		maze[8][9] = "free";
		maze[9][9] = "free";
		maze[1][10] = "free";
		maze[2][10] = "free";
		maze[3][10] = "free";
		maze[4][10] = "free";
		maze[9][10] = "free";
		maze[10][10] = "free";
		
		// This creates the maze
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 12; x++) {
				if (maze[x][y] == "free") {
					maze[x][y] = " ";
				} else {
					maze[x][y] = "#";
				}
			}
		}
		// The symbols for the mouse, cheese, and the cat
		maze[mouseRow][mouseCol] = "%";
		maze[cheeseRow][cheeseCol] = "$";
		maze[catRow][catCol] = "C";			
	}
	// Prints out game ending message
	private boolean gameWon() {
		return this.gameWon;
	}
	
	//The score when moving throughout the maze
	private int getScore() {
		return this.score;
	}
	
	// This prints out the maze when it's called from the main method
	private void printMaze() {
		System.out.println("\n");
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 12; x++) {
				System.out.print(maze[x][y]);
			}
			System.out.print("\n");
		}
	}
	
	
	// This part of the program shows when the mouse moves and keeps score. 
	// Also, tells you where the mouse can and can't move throughout the maze.
	// Also, tells when the mouse gets eaten by the cat.
	private void makeMove(int row, int col) {
		this.score--;
		int newRow = mouseRow + row;
		int newCol = mouseCol + col;
		if (maze[newRow][newCol] == "#") {
			System.out.println("\nYou cannot move there!");
		} else if (maze[newRow][newCol] == "$") {
			this.score += 100;
			maze[mouseRow][mouseCol] = " ";
			this.gameWon = true;
			printMaze();
			System.out.println("GAME OVER! MOUSE GOT THE CHEESE!");
			System.out.println("Your score was " + this.score);
		} else if (maze[newRow][newCol] == "C") {
			this.score -= 100;
			maze[mouseRow][mouseCol] = " ";
			this.gameWon = true;
			printMaze();
			System.out.println("GAME OVER! YOU LOST! THE CAT GOT THE MOUSE");
			System.out.println("Your score was " + this.score);
		} else {
			maze[mouseRow][mouseCol] = " ";
			maze[newRow][newCol] = "%";
			this.mouseRow = newRow;
			this.mouseCol = newCol;
		}
	}
	
	// This deals with the movement of the mouse when inputing north, south, east, or west from the main method
	private void parseCmd(String input) {
		if (input.equals("n")) {
			makeMove(0, -1);
		} else if (input.equals("s")) {
			makeMove(0, 1);
		} else if (input.equals("e")) {
			makeMove(1, 0);
		} else if (input.equals("w")) {
			makeMove(-1, 0);
		} else {
			System.out.println("Invalid choice");
		}
	} 
	
	// This prints out the header, brings up the maze, and gets user input for movement
	public static void main(String[] args) {
		MouseRace2 mouseRace = new MouseRace2();
		Scanner scan = new Scanner(System.in);
		while (!mouseRace.gameWon()) {
			mouseRace.printMaze();
			System.out.println("\nYour current score: " + mouseRace.getScore());
			System.out.print("Select a move direction (n/s/w/e) or press u for undo:");
			String input = scan.next();
			mouseRace.parseCmd(input);
		}
		scan.close();
	}
}
		
		
		
		
		


