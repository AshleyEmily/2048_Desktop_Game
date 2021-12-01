package Model;


public class Board{

    private Number [][]boardData = new Number[4][4];
    private Score gameScore;
    private boolean gameWon;
    private int totalTiles;
    private int highCell;
    

    public Board() {
		gameScore = new Score();
		gameWon = false;
		highCell = 0;
		totalTiles = 0;
    }
    public void populateTiles(int x_rand, int y_rand) {
    	boardData[x_rand][y_rand] = new Number(x_rand, y_rand);
    	totalTiles++;
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
    public void setHighCell(int hc) {
    	highCell = hc;
    }
    
    public boolean isBoardFull()
    {
    	return (totalTiles >= 16);
    }
    
    public void combineMatch(Number tile) {
    	tile.updateNumber();
		gameScore.updateScore(tile.getNumValue());
		if (highCell < tile.getNumValue()) highCell = tile.getNumValue();
    	if (highCell == 2048) gameWon = true;
    	totalTiles--;
    }
    
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
		SeekCellsContext context = new SeekCellsContext(new seekCellsRightRow());
		for (int j = 3; j >= 0; j--) {						//from left to right
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
    
    public void moveUp() {
		SeekCellsContext context = new SeekCellsContext(new seekCellsLeftRow());
		for (int j = 0; j < 4; j++) {						//from right to left
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
    
    public void moveRight() {

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
    
    public void moveLeft() {
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

}
