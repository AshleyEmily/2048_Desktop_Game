package Model;

public class seekCellsDownCol implements seekCells{
	 
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
	
	@Override
	public int findNextAvailable(int x, int y, Number[][] boardData) {
		if (x == 0) return x;
		if (boardData[x-1][y] != null && !boardData[x][y].equals(boardData[x-1][y])) return x;
    	int nextX = x;
    	for (int i = x - 1; i >= 0; i--) {				//find the farthest possible empty cell in that row
    		if (boardData[i][y] == null) nextX = i;
    		else {
    			nextX = i+1;
    			break;
    		}
    	}
    	if (nextX == 0) return nextX;					//if the cell is at the farthest end, return that
    	else if (boardData[x][y].equals(boardData[nextX-1][y])) return nextX-1; //if the cell after the furthest available is a match, take that as next cell
    	else return nextX; //return if not at the end or not a match
	}
}
