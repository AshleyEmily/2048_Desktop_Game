
package Model;

import Controller.Cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;


public class Model {

	Board game;
	private Random random;
	
	//VIEW PURPOSES
	private static final int FRAME_THICKNESS = 16;
 	private static final int GRID_WIDTH = 4;
	private Cell[][] grid;

	public Model(){
		game = new Board();
		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
		this.random = new Random();
		initializeGrid();
	}
	
	public Board getBoard() {
		return game;
	}
	
	public Cell[][] getGrid(){
		return grid;
	}
	
	public void modelMoveUp(){
		game.moveUp();
		updateCellGrid();
	}
	
	public void modelMoveDown(){
		game.moveDown();
		updateCellGrid();
	}
	
	public void modelMoveLeft(){
		game.moveLeft();
		updateCellGrid();
	}
	
	public void modelMoveRight(){
		game.moveRight();
		updateCellGrid();
	}
	
	
	
 //INITIALIZES VIEW COMPONENT OF BOARD
   	public void initializeGrid() {
 		int xx = FRAME_THICKNESS;
 		for (int x = 0; x < GRID_WIDTH; x++) {
 			int yy = FRAME_THICKNESS;
 			for (int y = 0; y < GRID_WIDTH; y++) {
 				Cell cell = new Cell();
 				cell.setCellLocation(xx, yy);
 				grid[x][y] = cell;
 				yy += FRAME_THICKNESS + Cell.getCellWidth();
 			}
 			xx += FRAME_THICKNESS + Cell.getCellWidth();
 		}
 	}

 // ADDS CELL AND NUMBER TILES BY RANDOM 	
	 public void addNewCell(){
	    	int x_rand;
	    	int y_rand;
	    	do {
	    	x_rand = random.nextInt(4);
	    	y_rand = random.nextInt(4);
	    	}while (game.getTile(x_rand, y_rand)!= null && grid[x_rand][y_rand].getValue() != 0);
	    	grid[x_rand][y_rand].setValue(2);			 
	    	game.populateTiles(x_rand, y_rand);
	 }
	 
	 
/**---------------------------------------------------------------**/
	 /** NEED TO REMOVE DRAW AND GETPREFERREDSIZE FROM MODEL**/
  	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		Dimension d = getPreferredSize();
		g.fillRect(0, 0, d.width, d.height);

		for (int x = 0; x < GRID_WIDTH; x++) {
			for (int y = 0; y < GRID_WIDTH; y++) {
				grid[x][y].drawCell(g);
			}
		}
  	}

   public Dimension getPreferredSize() {
	   int width = GRID_WIDTH * Number.getCellWidth() +
				FRAME_THICKNESS * 5;
		return new Dimension(width, width);
	}
	/**------------------------------------------------------**/

   	public boolean isGameOver() {
		return game.isBoardFull() && !isMovePossible();
	}
   	
 	private boolean isMovePossible() {
		for (int x = 0; x < GRID_WIDTH; x++) {
			for (int y = 0; y < (GRID_WIDTH - 1); y++) {
				int yy = y + 1;
				if (game.getTile(x, y).getNumValue() == game.getTile(x, yy).getNumValue()) return true;
			}
		}
		for (int y = 0; y < GRID_WIDTH; y++) {
			for (int x = 0; x < (GRID_WIDTH - 1); x++) {
				int xx = x + 1;
				if (game.getTile(x, y).getNumValue() == game.getTile(xx, y).getNumValue()) return true;
			}
		}
		return false;
	}
 	
 	public void gameOver() {
 	}

	public void setVisible(boolean b) { }

	public int getScore() {
		return game.getGameScore().getScore();
	}

	public int getHighScore() {
		return game.getGameScore().getHighScore();
	}

	public int getHighCell() {
		return game.getHighCell();
	}
	
	
	//UPDATES THE VIEW COMPONENT OF THE BOARD
	public void updateCellGrid() {
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (game.getTile(x, y) == null) {
					grid[x][y].setValue(0);
				}
				else {
					grid[x][y].setValue(game.getTile(x, y).getNumValue());
				}
			}
		}
	}
	
	//FOR DEBUGGING PURPOSES
	public void printCellGridandBoard() {
		System.out.println("CELL GRID");
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				System.out.print(" [" + grid[x][y].getValue() + "] ");
			}
			System.out.print("\n");
		}
		
		System.out.println("\nBOARD");
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (game.getTile(x, y) == null) System.out.print(" [ ] ");
				else System.out.print(" [" + game.getTile(x, y).getNumValue() + "] ");
			}
			System.out.print("\n");
		}
		System.out.print("\n________________________________\n");


	}
	


}

