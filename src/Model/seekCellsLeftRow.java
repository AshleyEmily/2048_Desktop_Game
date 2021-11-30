package Model;

public class seekCellsLeftRow implements seekCells{
	
	
	 /*
     * Find next available cell in a row for the tiles to be moved to the left 
     * 
     * eg. [2][4][ ][4] <-- [2][8][ ][ ]
     * 
     * @param coordinates of the tile to-be-moved
     * @return the next empty y-coordinate in that row or the y-coordinate of the closest tile that matches
     * 
     */
	public int findNextAvailable(int x, int y, Number[][] boardData) {
		if (y == 0) return y;
		if (boardData[x][y-1] != null && !boardData[x][y].equals(boardData[x][y-1])) return y;

    	int nextY = y;
    	for (int i = y - 1; i >= 0; i--) {				//find the farthest possible empty cell in that row
    		if (boardData[x][i] == null) nextY = i;
    		else {
    			nextY = i + 1;
    			break;
    		}
    	}
    	if (nextY == 0) return nextY;					//if the cell is at the furthest end, return that
    	else if (boardData[x][y].equals(boardData[x][nextY-1])) return nextY-1; //if the cell after the furthest available is a match, take that as next cell
    	else return nextY; //return if not at the end or not a match
    }
}
