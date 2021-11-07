package Model;

public class seekCellsRightRow implements seekCells{
	public int findNextAvailable(int x, int y, Number[][] boardData) {
    	if (y == 3) return y;
    	int nextY = y;
    	for (int i = y + 1; i < 4; i++) {				//find the farthest possible empty cell in that row
    		if (boardData[x][i] == null) nextY = i;
    	}
    	if (nextY == 3) return nextY;					//if the cell is at the furthest end, return that
    	else if (boardData[x][y].equals(boardData[x][nextY+1])) return nextY+1; //if the cell after the furthest available is a match, take that as next cell
    	else return nextY; //return if not at the end or not a match
    }

}
