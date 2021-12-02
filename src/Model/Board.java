package Model;


public class Board{

    private Number [][]boardData = new Number[4][4];
    private Score gameScore;
    private int totalTiles;
    private int highCell;
    

    public Board() {
		gameScore = new Score();
		totalTiles = 0;
    }
    
    //INSERT NUMBER TILE INTO BOARD AT (x, y) COORDINATE
    public void populateTiles(int x, int y) {
    	boardData[x][y] = new Number();
    	totalTiles++;
    }
    
    
    //GETTERS AND SETTERS
    public Number getTile(int x, int y) {
    	return boardData[x][y];
    }
    
    public Score getGameScore() {
    	return gameScore;
    }
    
    public int getHighCell() {
    	return highCell;
    }
    public void setHighCell(int hc) {
    	highCell = hc;
    }
    
    public int getTotalTiles() {
    	return totalTiles;
    }
    
    //CHECKS IF BOARD IS FULL 
    public boolean isBoardFull()
    {
    	return (totalTiles >= 16);
    }
    
    //COMBINES NUMBER TILES
    public void combineMatch(Number tile) {
    	tile.updateNumber();
		gameScore.updateScore(tile.getNumValue());
		if (highCell < tile.getNumValue()) highCell = tile.getNumValue();
    	totalTiles--;
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
		SeekCellsContext context = new SeekCellsContext(new seekCellsRightRow());
		for (int j = 3; j >= 0; j--) {						//from left to right
			int next;
			for (int i = 0; i < 4; i++) {					//top to bottom
				if (boardData[i][j] == null) continue;
				next = context.executeMethod(i, j, boardData);
				if (j == next) continue; 					//does not move tile
				else if (boardData[i][next] == null) {		//moves to empty cell
					boardData[i][next] = boardData[i][j];
				}
				else{										//moves to matched tile
					boardData[i][next] = boardData[i][j];
					combineMatch(boardData[i][next]);
				}
				boardData[i][j] = null;
			}
		}
    }
    
    public void moveUp() {
		SeekCellsContext context = new SeekCellsContext(new seekCellsLeftRow());
		for (int j = 0; j < 4; j++) {						//from right to left
			int next;
			for (int i = 0; i < 4; i++) {					//top to bottom
				if (boardData[i][j] == null) continue;
				next = context.executeMethod(i, j, boardData);;
				if (j == next) continue; 					//does not move tile
				else if (boardData[i][next] == null) {		//move to empty cell
					boardData[i][next] = boardData[i][j];
				}
				else{										//move to matched tile
					boardData[i][next] = boardData[i][j];
					combineMatch(boardData[i][next]);
				}
				boardData[i][j] = null;
			}
		}
    }
    
    public void moveRight() {

		SeekCellsContext context = new SeekCellsContext(new seekCellsUpCol());
		for (int i = 3; i >= 0; i--) {						//from bottom up
			int next;
			for (int j = 0; j < 4; j++) {					//left to right
				if (boardData[i][j] == null) continue;
				next = context.executeMethod(i, j, boardData);

				if (i == next) continue; 					//does not move tile
				else if (boardData[next][j] == null) {		//moves to empty cell
					boardData[next][j] = boardData[i][j];
				}
				else{										//moves to matched tile
					boardData[next][j] = boardData[i][j];
					combineMatch(boardData[next][j]);
				}
				boardData[i][j] = null;
			}
		}
    }
    
    public void moveLeft() {
    	SeekCellsContext context = new SeekCellsContext(new seekCellsDownCol());
		for (int i = 0; i < 4; i++) {						//from up to down
			int next;
			for (int j = 0; j < 4; j++) {					//left to right
				if (boardData[i][j] == null) continue;
				next = context.executeMethod(i, j, boardData);

				if (i == next) continue; 					//does not move tile
				else if (boardData[next][j] == null) {		//moves to empty cell
					boardData[next][j] = boardData[i][j];
				}
				else{										//moves to matched tile
					boardData[next][j] = boardData[i][j];
					combineMatch(boardData[next][j]);
				}
				boardData[i][j] = null;
			}
		}
    }

}
