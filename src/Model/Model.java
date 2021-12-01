
package Model;
import Controller.Settings;

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
	public Settings themes;

	 /**Add*/
	 private boolean arrowActive;

	public Model(){
		game = new Board();
		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
		this.random = new Random();
		initializeGrid();
		themes = new Settings();

		/**Add*/
		this.arrowActive = false;
	}
	
	public void setTheme(int choice) {
		themes.setTheme(choice);
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
	    	grid[x_rand][y_rand].setCellColor(Color.decode(themes.getTheme()[0]));
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
			    	grid[x][y].setCellColor(getTileColor(grid[x][y].getValue()));

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
	


	/**Add*/
	public boolean ArrowActive(){
		return arrowActive;
	}

	public void setArrowActive(boolean arrowActive){
		this.arrowActive = arrowActive;
	}

	public boolean moveCellsDown() {
		boolean dirty = false;

		if (moveCellsDownLoop())    dirty = true;

		for (int x = 0; x < GRID_WIDTH; x++) {
			for (int y = GRID_WIDTH - 1; y > 0; y--) {
				int yy = y - 1;
				dirty = combineCells(x, yy, x, y, dirty);
			}
		}

		if (moveCellsDownLoop())    dirty = true;

		return dirty;
	}

	private boolean moveCellsDownLoop() {
		boolean dirty = false;

		for (int x = 0; x < GRID_WIDTH; x++) {
			boolean columnDirty = false;
			do {
				columnDirty = false;
				for (int y = GRID_WIDTH - 1; y > 0; y--) {
					int yy = y - 1;
					boolean cellDirty = moveCell(x, yy, x, y);
					if (cellDirty) {
						columnDirty = true;
						dirty = true;
					}
				}
			} while (columnDirty);
		}

		return dirty;
	}

	private boolean combineCells(int x1, int y1, int x2, int y2,
								 boolean dirty) {
		if (!grid[x1][y1].isZeroValue()) {
			int value = grid[x1][y1].getValue();
			if (grid[x2][y2].getValue() == value) {
				int newValue = value + value;
				grid[x2][y2].setValue(newValue);
				grid[x1][y1].setValue(0);
//				updateScore(newValue, newValue);
				dirty = true;
			}
		}
		return dirty;
	}
	private boolean moveCell(int x1, int y1, int x2, int y2) {
		boolean dirty = false;
		if (!grid[x1][y1].isZeroValue()
				&& (grid[x2][y2].isZeroValue())) {
//			if (DEBUG) {
//				System.out.println(displayMoveCell(x1, y1, x2, y2));
//			}
			int value = grid[x1][y1].getValue();
			grid[x2][y2].setValue(value);
			grid[x1][y1].setValue(0);
			dirty = true;
		}
		return dirty;
	}
	
	private Color getTileColor(int value) {
      Color color = Color.WHITE;

      switch (value) {
//          case 2:     color = new Color(238, 228, 218);
//              break;
          case 2:     color = Color.decode(themes.getTheme()[0]);
              break;
          case 4:     color = Color.decode(themes.getTheme()[1]);
              break;
          case 8:     color = Color.decode(themes.getTheme()[2]);
              break;
          case 16:    color = Color.decode(themes.getTheme()[3]);
              break;
          case 32:    color = Color.decode(themes.getTheme()[4]);
              break;
          case 64:    color = Color.decode(themes.getTheme()[5]);
              break;
          case 128:   color = Color.decode(themes.getTheme()[6]);
              break;
          case 256:   color = Color.decode(themes.getTheme()[7]);
              break;
          case 512:   color = Color.decode(themes.getTheme()[8]);
              break;
          case 1024:  color = Color.decode(themes.getTheme()[9]);
              break;
          case 2048:  color = Color.decode(themes.getTheme()[10]);
              break;
          default:    color = new Color(43, 43, 0);
              break;
      }

      return color;
  }

}

