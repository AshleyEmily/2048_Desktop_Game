package Model;

import java.util.Random;

public class Board{

    private Number [][]boardData = new Number[4][4];
    private Score gameScore;
    private boolean gameWon;
    private boolean boardFull;
    private int highCell;
    

    public Board() {
    	populateTiles();
		populateTiles();
		gameScore = new Score();
		gameWon = false;
		boardFull = false;
		highCell = 2;
    }
    public void populateTiles() {
    	Random rand = new Random();
    	rand.setSeed(10);
    	int x_rand;
    	int y_rand;
    	int counter = 0;
    	do {
    	x_rand = rand.nextInt(4);
    	y_rand = rand.nextInt(4);
    	counter++;
    	}while (boardData[x_rand][y_rand] != null && counter <= 16);
    	if (counter == 16) boardFull = true;
    	boardData[x_rand][y_rand] = new Number(x_rand, y_rand);
    }
    
    public Number getTile(int x, int y) {
    	return boardData[x][y];
    }
    
    public Score getGameScore() {
    	return gameScore;
    }
    
    public boolean getGameStatus() {
    	return gameWon;
    }
    
    public int getHighCell() {
    	return highCell;
    }
    
    public boolean isBoardFull()
    {
    	return boardFull;
    }
    
    public void combineMatch(Number tile) {
    	tile.updateNumber();
		gameScore.updateScore(tile.getNumValue());
		if (highCell < tile.getNumValue()) highCell = tile.getNumValue();
    	if (highCell == 2048) gameWon = true;
		
    }
    
/*
 * Find NEXT AVAILABLE CELL Methods:
 * @param coordinates of tile to-be-moved
 * @return next x-coordinate (for column) or next y-coordinate (for row) 
 */
    
    /*
     * Find next available cell in a row for the tiles to be moved to the right 
     * 
     * eg. [2][4][ ][4] --> [ ][ ][2][8]
     * 
     * @param coordinates of the tile to-be-moved
     * @return the next empty y-coordinate in that row or the y-coordinate of the closest tile that matches
     * 
     */
//    public int RightnextAvailableInRow(int x, int y) {
//    	if (y == 3) return y;
//    	int nextY = y;
//    	for (int i = y + 1; i < 4; i++) {				//find the farthest possible empty cell in that row
//    		if (boardData[x][i] == null) nextY = i;
//    	}
//    	if (nextY == 3) return nextY;					//if the cell is at the furthest end, return that
//    	else if (boardData[x][y].equals(boardData[x][nextY+1])) return nextY+1; //if the cell after the furthest available is a match, take that as next cell
//    	else return nextY; //return if not at the end or not a match
//    }
    
    
    /*
     * Find next available cell in a column for the tiles to be moved upwards
     * 
     * eg. [2][8][ ][4] 		[2][8][ ][4]			[2][8][2][4]
     * 	   		^			-->					-->		[4][4][ ][8]
     * 	   [2][ ][ ][ ]			[4][4][2][8]			[ ][ ][ ][ ]
     * 	   [2][4][2][8]			[ ][ ][ ][ ]			[ ][ ][ ][ ]
     * 
     * @param coordinates of the tile to-be-moved
     * @return the next empty x-coordinate in that column or the x-coordinate of the closest tile that matches
     * 
     */
//    public int UpnextAvailableInCol(int x, int y) {
//    	if (x == 3) return x;
//    	int nextX = x;
//    	for (int i = x + 1; i < 4; i++) {				//find the farthest possible empty cell in that row
//    		if (boardData[i][y] == null) nextX = i;
//    	}
//    	if (nextX == 3) return nextX;					//if the cell is at the farthest end, return that
//    	else if (boardData[x][y].equals(boardData[nextX+1][y])) return nextX+1; //if the cell after the furthest available is a match, take that as next cell
//    	else return nextX; //return if not at the end or not a match
//    }
    
    
    /*
     * Find next available cell in a row for the tiles to be moved to the left 
     * 
     * eg. [2][4][ ][4] <-- [2][8][ ][ ]
     * 
     * @param coordinates of the tile to-be-moved
     * @return the next empty y-coordinate in that row or the y-coordinate of the closest tile that matches
     * 
     */
//    public int LeftnextAvailableInRow(int x, int y) {
//    	if (y == 0) return y;
//    	int nextY = y;
//    	for (int i = y - 1; i >= 0; i--) {				//find the farthest possible empty cell in that row
//    		if (boardData[x][i] == null) nextY = i;
//    	}
//    	if (nextY == 0) return nextY;					//if the cell is at the furthest end, return that
//    	else if (boardData[x][y].equals(boardData[x][nextY-1])) return nextY-1; //if the cell after the furthest available is a match, take that as next cell
//    	else return nextY; //return if not at the end or not a match
//    }
    
    
    /*
     * Find next available cell in a column for the tiles to be moved downwards
     * 
     * eg. [2][8][2][4] 		[ ][8][ ][ ]				[ ][ ][ ][ ]
     * 	   [2][4][ ][ ]		-->	[4][4][2][4]	-->
     * 			v											[4][8][ ][ ]
     * 	   [2][ ][ ][ ]			[2][ ][ ][ ]				[2][4][2][4]
     * 
     * @param coordinates of the tile to-be-moved
     * @return the next empty x-coordinate in that column or the x-coordinate of the closest tile that matches
     * 
     */
//    public int DownnextAvailableInCol(int x, int y) {
//    	if (x == 0) return x;
//    	int nextX = x;
//    	for (int i = x - 1; i >= 0; i--) {				//find the farthest possible empty cell in that row
//    		if (boardData[i][y] == null) nextX = i;
//    	}
//    	if (nextX == 0) return nextX;					//if the cell is at the farthest end, return that
//    	else if (boardData[x][y].equals(boardData[nextX-1][y])) return nextX-1; //if the cell after the furthest available is a match, take that as next cell
//    	else return nextX; //return if not at the end or not a match
//    }
    
    public void changeTheme(int choice) {
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			if (boardData[i][j] != null) boardData[i][j].setTheme(choice);
    		}
    	}
    }
    

/*
 * MOVE METHODS: Makes calls to NEXT AVAILABLE METHODS and updates the Number Tiles of the Board(numValue and Coordinates)
 * checks if the next coordinate passed back by NEXT AVAILABLE METHODS is:
 * an empty tile (moves number tile to new coordinate), 
 * a matched tile (moves number tile to new coordinate and updates number), 
 * or the same coordinate (does nothing)
 * Changes previously occupied cell to null
 * @return nothing
 * @param nothing
 */
    public void moveDown() {
    	SeekCellsContext context = new SeekCellsContext(new seekCellsUpCol());
    	for (int i = 3; i >= 0; i--) {						//from bottom up
    		int next;
    		for (int j = 0; j < 4; j++) {					//left to right
    			if (boardData[i][j] == null) continue;
    			next = context.executeMethod(i, j, boardData);
    			
    			if (i == next) continue; 					//does not move tile
    			else if (boardData[next][j] == null) {		//moves to empty cell
    				boardData[i][j].moveToNewPlace(next, j);
    				boardData[next][j] = boardData[i][j];
    			}
    			else{										//moves to matched tile
    				boardData[i][j].moveToNewPlace(next, j);
    				boardData[next][j] = boardData[i][j];
    				combineMatch(boardData[next][j]);
    			}
    			boardData[i][j] = null;
    		}
    	}
    }
    public void moveUp() {
    	SeekCellsContext context = new SeekCellsContext(new seekCellsDownCol());
    	for (int i = 0; i < 4; i++) {						//from up to down
    		int next;
    		for (int j = 0; j < 4; j++) {					//left to right
    			if (boardData[i][j] == null) continue;
    			next = context.executeMethod(i, j, boardData);
    			
    			if (i == next) continue; 					//does not move tile
    			else if (boardData[next][j] == null) {		//moves to empty cell
    				boardData[i][j].moveToNewPlace(next, j);
    				boardData[next][j] = boardData[i][j];
    			}
    			else{										//moves to matched tile
    				boardData[i][j].moveToNewPlace(next, j);
    				boardData[next][j] = boardData[i][j];
    				combineMatch(boardData[next][j]);
    			}
    			boardData[i][j] = null;
    		}
    	}
    }
    public void moveRight() {
    	SeekCellsContext context = new SeekCellsContext(new seekCellsRightRow());
    	for (int j = 0; j < 4; j++) {						//from left to right
    		int next;
    		for (int i = 0; i < 4; i++) {					//top to bottom
    			if (boardData[i][j] == null) continue;
    			next = context.executeMethod(i, j, boardData);
    			if (j == next) continue; 					//does not move tile
    			else if (boardData[i][next] == null) {		//moves to empty cell
    				boardData[i][j].moveToNewPlace(i, next);
    				boardData[i][next] = boardData[i][j];
    			}
    			else{										//moves to matched tile
    				boardData[i][j].moveToNewPlace(i, next);
    				boardData[i][next] = boardData[i][j];
    				combineMatch(boardData[i][next]);
    			}
    			boardData[i][j] = null;
    		}
    	}
    }
    public void moveLeft() {
    	SeekCellsContext context = new SeekCellsContext(new seekCellsLeftRow());
    	for (int j = 3; j >= 0; j--) {						//from right to left
    		int next;
    		for (int i = 0; i < 4; i++) {					//top to bottom
    			if (boardData[i][j] == null) continue;
    			next = context.executeMethod(i, j, boardData);;
    			if (j == next) continue; 					//does not move tile
    			else if (boardData[i][next] == null) {		//move to empty cell
    				boardData[i][j].moveToNewPlace(i, next);
    				boardData[i][next] = boardData[i][j];
    			}
    			else{										//move to matched tile	
    				boardData[i][j].moveToNewPlace(i, next);
    				boardData[i][next] = boardData[i][j];
    				combineMatch(boardData[i][next]);
    			}
    			boardData[i][j] = null;
    		}
    	}
    }
    
//    
//    public Number[][] getBoardData() {
//        // will change this later
//        return boardData;
//    }
//
//    public int[][] updateBoardData() {
//        // will also change this later
//        return boardData;
//    }


}
