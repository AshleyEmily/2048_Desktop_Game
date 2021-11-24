
package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Model extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	Board game;
	private static final int FRAME_THICKNESS = 16;
 	private static final int GRID_WIDTH = 4;
  

	public Model(){
		game = new Board();
        addKeyListener(this);
	}
  
//   	public void initializeGrid() {
// 		int xx = FRAME_THICKNESS;
// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			int yy = FRAME_THICKNESS;
// 			for (int y = 0; y < GRID_WIDTH; y++) {
// 				Cell cell = new Cell(0);
// 				cell.setCellLocation(xx, yy);
// 				grid[x][y] = cell;
// 				yy += FRAME_THICKNESS + Cell.getCellWidth();
// 			}
// 			xx += FRAME_THICKNESS + Cell.getCellWidth();
// 		}
// 	}
	
	 @Override
	    public void keyTyped(KeyEvent e) {
	        // invalid
	    }

	    /**
	     * @Override
	     * input key action and reflect based on the input.
	     * */
	    public void keyPressed(KeyEvent e) {
	        int keyCode = e.getKeyCode();
	        if (!isMovePossible()) gameOver();
	        switch (keyCode){
	            case KeyEvent.VK_UP:
	            	game.moveUp();
	            	if (!game.isBoardFull())game.populateTiles();
	                break;

	            case KeyEvent.VK_DOWN:
	            	game.moveDown();
	            	game.populateTiles();
	                break;

	            case KeyEvent.VK_RIGHT:
	            	game.moveRight();
	            	game.populateTiles();
	                break;

	            case KeyEvent.VK_LEFT:
	            	game.moveLeft();
	            	game.populateTiles();
	                break;

	            default:
	                break;
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {

	    }

	    public void setVisible(boolean b) {
	    }
	    
	    
	    public int getScore() {
	    	return game.getGameScore().getScore();
	    }
	    
	    public int getHighScore() {
	    	return game.getGameScore().getHighScore();
	    }
	   
	    public int getHighCell() {
	    	return game.getHighCell();
	    }
  

  	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		Dimension d = getPreferredSize();
		g.fillRect(0, 0, d.width, d.height);

		for (int x = 0; x < GRID_WIDTH; x++) {
			for (int y = 0; y < GRID_WIDTH; y++) {
				if (game.getTile(x, y) != null) game.getTile(x, y).draw(g);
				else {
					g.setColor(Color.GRAY);
					g.fillRect(x, y,
			               120, 120);
				}
			}
		}
  	}
      
      public Dimension getPreferredSize() {
		int width = GRID_WIDTH * Number.getCellWidth() +
				FRAME_THICKNESS * 5;
		return new Dimension(width, width);
	}
      
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

}




//	    public static void main(String [] args) {
//	    	Model start = new Model();
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	start.game.moveUp();
//	    	start.game.populateTiles();
//    		System.out.println("\n");
//
//	    	
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	start.game.moveLeft();
//	    	start.game.populateTiles();
//	    	
//    		System.out.println("\n");
//
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	
//	    	start.game.moveRight();
//	    	start.game.populateTiles();
//	    	
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    }



//	private static final int GRID_WIDTH = 4;

	///private boolean arrowActive;

//	private int highScore;
// 	private int highCell;
//	private int currentScore;
//	private int currentCell;

// 	private Cell[][] grid;

// 	private Random random;

// 	public Model(){
// 		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
// 		this.random = new Random();
// 		this.highScore = 0;
// 		this.highCell = 0;
// 		this.currentScore = 0;
// 		this.currentCell = 0;
// 		this.arrowActive = false;
// 		initializeGrid();
// 	}



// 	public void setHighScores() {
// 		highScore = (currentScore > highScore) ?
// 				currentScore : highScore;
// 		highCell = (currentCell > highCell) ?
// 				currentCell : highCell;
// 		currentScore = 0;
// 		currentCell = 0;
// 	}



// 	private boolean isGridFull() {
// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			for (int y = 0; y < GRID_WIDTH; y++) {
// 				if (grid[x][y].isZeroValue()) {
// 					return false;
// 				}
// 			}
// 		}
// 		return true;
// 	}

// 	private boolean isMovePossible() {
// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			for (int y = 0; y < (GRID_WIDTH - 1); y++) {
// 				int yy = y + 1;
// 				if (grid[x][y].getValue() == grid[x][yy].getValue()) {
// 					return true;
// 				}
// 			}
// 		}

// 		for (int y = 0; y < GRID_WIDTH; y++) {
// 			for (int x = 0; x < (GRID_WIDTH - 1); x++) {
// 				int xx = x + 1;
// 				if (grid[x][y].getValue() == grid[xx][y].getValue()) {
// 					return true;
// 				}
// 			}
// 		}

// 		return false;
// 	}

// 	public void addNewCell() {
// 		int value = (random.nextInt(10) < 9) ?  2 : 4;

// 		boolean locationFound = false;
// 		while(!locationFound) {
// 			int x = random.nextInt(GRID_WIDTH);
// 			int y = random.nextInt(GRID_WIDTH);
// 			if (grid[x][y].isZeroValue()) {
// 				grid[x][y].setValue(value);
// 				locationFound = true;
// 				if (DEBUG) {
// 					System.out.println(displayAddCell(x, y));
// 				}
// 			}
// 		}

// 		updateScore(0, value);
// 	}

// 	private String displayAddCell(int x, int y) {
// 		StringBuilder builder = new StringBuilder();
// 		builder.append("Cell added at [");
// 		builder.append(x);
// 		builder.append("][");
// 		builder.append(y);
// 		builder.append("].");

// 		return builder.toString();
// 	}

// 	public boolean moveCellsUp() {
// 		boolean dirty = false;

// 		if (moveCellsUpLoop())  dirty = true;

// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			for (int y = 0; y < (GRID_WIDTH - 1); y++) {
// 				int yy = y + 1;
// 				dirty = combineCells(x, yy, x, y, dirty);
// 			}
// 		}

// 		if (moveCellsUpLoop())  dirty = true;

// 		return dirty;
// 	}

// 	private boolean moveCellsUpLoop() {
// 		boolean dirty = false;

// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			boolean columnDirty = false;
// 			do {
// 				columnDirty = false;
// 				for (int y = 0; y < (GRID_WIDTH - 1); y++) {
// 					int yy = y + 1;
// 					boolean cellDirty = moveCell(x, yy, x, y);
// 					if (cellDirty) {
// 						columnDirty = true;
// 						dirty = true;
// 					}
// 				}
// 			} while (columnDirty);
// 		}

// 		return dirty;
// 	}

// 	public boolean moveCellsDown() {
// 		boolean dirty = false;

// 		if (moveCellsDownLoop())    dirty = true;

// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			for (int y = GRID_WIDTH - 1; y > 0; y--) {
// 				int yy = y - 1;
// 				dirty = combineCells(x, yy, x, y, dirty);
// 			}
// 		}

// 		if (moveCellsDownLoop())    dirty = true;

// 		return dirty;
// 	}

// 	private boolean moveCellsDownLoop() {
// 		boolean dirty = false;

// 		for (int x = 0; x < GRID_WIDTH; x++) {
// 			boolean columnDirty = false;
// 			do {
// 				columnDirty = false;
// 				for (int y = GRID_WIDTH - 1; y > 0; y--) {
// 					int yy = y - 1;
// 					boolean cellDirty = moveCell(x, yy, x, y);
// 					if (cellDirty) {
// 						columnDirty = true;
// 						dirty = true;
// 					}
// 				}
// 			} while (columnDirty);
// 		}

// 		return dirty;
// 	}

// 	public boolean moveCellsLeft() {
// 		boolean dirty = false;

// 		if (moveCellsLeftLoop())    dirty = true;

// 		for (int y = 0; y < GRID_WIDTH; y++) {
// 			for (int x = 0; x < (GRID_WIDTH - 1); x++) {
// 				int xx = x + 1;
// 				dirty = combineCells(xx, y, x, y, dirty);
// 			}
// 		}

// 		if (moveCellsLeftLoop())    dirty = true;

// 		return dirty;
// 	}

// 	private boolean moveCellsLeftLoop() {
// 		boolean dirty = false;

// 		for (int y = 0; y < GRID_WIDTH; y++) {
// 			boolean rowDirty = false;
// 			do {
// 				rowDirty = false;
// 				for (int x = 0; x < (GRID_WIDTH - 1); x++) {
// 					int xx = x + 1;
// 					boolean cellDirty = moveCell(xx, y, x, y);
// 					if (cellDirty) {
// 						rowDirty = true;
// 						dirty = true;
// 					}
// 				}
// 			} while (rowDirty);
// 		}

// 		return dirty;
// 	}

// 	public boolean moveCellsRight() {
// 		boolean dirty = false;

// 		if (moveCellsRightLoop())   dirty = true;

// 		for (int y = 0; y < GRID_WIDTH; y++) {
// 			for (int x = (GRID_WIDTH - 1); x > 0; x--) {
// 				int xx = x - 1;
// 				dirty = combineCells(xx, y, x, y, dirty);
// 			}
// 		}

// 		if (moveCellsRightLoop())   dirty = true;

// 		return dirty;
// 	}

// 	private boolean moveCellsRightLoop() {
// 		boolean dirty = false;

// 		for (int y = 0; y < GRID_WIDTH; y++) {
// 			boolean rowDirty = false;
// 			do {
// 				rowDirty = false;
// 				for (int x = (GRID_WIDTH - 1); x > 0; x--) {
// 					int xx = x - 1;
// 					boolean cellDirty = moveCell(xx, y, x, y);
// 					if (cellDirty) {
// 						rowDirty = true;
// 						dirty = true;
// 					}
// 				}
// 			} while (rowDirty);
// 		}

// 		return dirty;
// 	}

// 	private boolean combineCells(int x1, int y1, int x2, int y2,
// 								 boolean dirty) {
// 		if (!grid[x1][y1].isZeroValue()) {
// 			int value = grid[x1][y1].getValue();
// 			if (grid[x2][y2].getValue() == value) {
// 				int newValue = value + value;
// 				grid[x2][y2].setValue(newValue);
// 				grid[x1][y1].setValue(0);
// 				updateScore(newValue, newValue);
// 				dirty = true;
// 			}
// 		}
// 		return dirty;
// 	}

// 	private boolean moveCell(int x1, int y1, int x2, int y2) {
// 		boolean dirty = false;
// 		if (!grid[x1][y1].isZeroValue()
// 				&& (grid[x2][y2].isZeroValue())) {
// 			if (DEBUG) {
// 				System.out.println(displayMoveCell(x1, y1, x2, y2));
// 			}
// 			int value = grid[x1][y1].getValue();
// 			grid[x2][y2].setValue(value);
// 			grid[x1][y1].setValue(0);
// 			dirty = true;
// 		}
// 		return dirty;
// 	}

// 	private String displayMoveCell(int x1, int y1, int x2, int y2) {
// 		StringBuilder builder = new StringBuilder();
// 		builder.append("Moving cell [");
// 		builder.append(x1);
// 		builder.append("][");
// 		builder.append(y1);
// 		builder.append("] to [");
// 		builder.append(x2);
// 		builder.append("][");
// 		builder.append(y2);
// 		builder.append("].");

// 		return builder.toString();
// 	}

// 	private void updateScore(int value, int cellValue) {
// 		currentScore += value;
// 		currentCell = (cellValue > currentCell) ?
// 				cellValue : currentCell;
// 	}

// 	public Cell getCell(int x, int y) {
// 		return grid[x][y];
// 	}


	

// 	public void setHighScore(int highScore) {
// 		this.highScore = highScore;
// 	}


// 	public int getCurrentScore() {
// 		return currentScore;
// 	}

// 	public int getCurrentCell() {
// 		return currentCell;
// 	}

// 	public boolean isArrowActive() {
// 		return arrowActive;
// 	}

// 	public void setArrowActive(boolean arrowActive) {
// 		this.arrowActive = arrowActive;
// 	}

	

// 	}
// >>>>>>> main


