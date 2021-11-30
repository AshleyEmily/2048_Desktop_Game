
package Model;

import Controller.Cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;


public class Model {
	

	Board game;
	private static final int FRAME_THICKNESS = 16;
 	private static final int GRID_WIDTH = 4;

	 private Cell[][] grid;
	 private Random random;

	public Model(){
		game = new Board();
//        addKeyListener(this);

		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
		this.random = new Random();
		initializeGrid();
	}
  
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

	 public void addNewCell(){
		 int value = (random.nextInt(10) < 9) ?  2 : 4;

		 boolean locationFound = false;
		 while(!locationFound) {
			 int x = random.nextInt(GRID_WIDTH);
			 int y = random.nextInt(GRID_WIDTH);
			 if (grid[x][y].isZeroValue()) {
				 grid[x][y].setValue(value);
				 locationFound = true;

			 }
		 }
	 }

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

}

