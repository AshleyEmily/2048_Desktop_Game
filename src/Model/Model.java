package Model;
import Controller.Settings;

import Controller.Cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Model {

	Board game;
	private Random random;
	
	//VIEW PURPOSES
	private static final int FRAME_THICKNESS = 16;
 	private static final int GRID_WIDTH = 4;
	private Cell[][] grid;
	public Settings themes;
	
	//SCORES
	private int highScore;
	private int highCell;

	 /**Add*/
	 private boolean arrowActive;

	public Model(){
		game = new Board();
		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
		this.random = new Random();
		initializeGrid();
		themes = new Settings();
		retrieveScores();

		/**Add*/
		this.arrowActive = false;
	}
	
	public void resetModel() {
		game = new Board();
		this.grid = new Cell[GRID_WIDTH][GRID_WIDTH];
		this.random = new Random();
		initializeGrid();
		themes = new Settings();
		/**Add*/
		this.arrowActive = false;
	}
	
	//SETTER
	public void setTheme(int choice) {
		themes.setTheme(choice);
	}
	
	//GETTERS
	public Board getBoard() {
		return game;
	}
	public Cell[][] getGrid(){
		return grid;
	}
	public int getModelHighScore() {
		return highScore;
	}
	public int getScore() {
		return game.getGameScore().getScore();
	}
	public int getHighCell() {
		return highCell;
	}
	
	
	//MOVE METHODS
	public void modelMoveUp(){
		game.moveUp();
		updateCellGrid();
		updateScores();
	}
	public void modelMoveDown(){
		game.moveDown();
		updateCellGrid();
		updateScores();
	}
	public void modelMoveLeft(){
		game.moveLeft();
		updateCellGrid();
		updateScores();
	}
	public void modelMoveRight(){
		game.moveRight();
		updateCellGrid();
		updateScores();
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
	    	if (game.getTotalTiles() == 16) return;
	    	do {
	    	x_rand = random.nextInt(4);
	    	y_rand = random.nextInt(4);
	    	}while (game.getTile(x_rand, y_rand)!= null && grid[x_rand][y_rand].getValue() != 0);
	    	grid[x_rand][y_rand].setValue(2);
	    	grid[x_rand][y_rand].setCellColor(Color.decode(themes.getTheme()[0]));
	    	game.populateTiles(x_rand, y_rand);
	 }
	 
	 

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


   //CHECKS IF CONDITIONS ARE TRUE FOR GAME TO END
   	public boolean isGameOver() {
		if (getBoard().isBoardFull() && !isMovePossible()){
			return true;
		}else {
			return false;
		}
	}
   	
   	//CHECKS IF THERE ARE ANY POSSIBLE MOVES TO BE MADE IN TH BOARD
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

	
	private Color getTileColor(int value) {
      Color color = Color.WHITE;
      switch (value) {
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
	

	//SCORE METHOODS
	public void updateScores() {
		if (game.getGameScore().getHighScore() > highScore) 
			highScore = game.getGameScore().getHighScore();
		if (game.getHighCell() > highCell) 
			highCell = game.getHighCell();
	}
	
	public void saveGame() {
		try {
		      FileWriter myWriter = new FileWriter("savedScores.txt");
		      myWriter.write(String.valueOf(highScore) + "\n" + String.valueOf(highCell));
		      myWriter.close();
		      System.out.println("Saved");
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void retrieveScores() {
		 try {
	            //Open the file using FileReader Object.
	            FileReader file = new FileReader("savedScores.txt");
	            BufferedReader buff = new BufferedReader(file);
	            String line = buff.readLine();
	            highScore = Integer.parseInt(line);
	            line = buff.readLine();
	            highCell = Integer.parseInt(line);
	            buff.close();
	        }
	        catch (IOException e) {
	            System.out.println("Error -- " + e.toString());
	        }
	}

}

