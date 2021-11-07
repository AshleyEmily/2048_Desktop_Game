package Model;

public class seekCellsUpCol implements seekCells{
	@Override
	public int findNextAvailable(int x, int y, Number[][] boardData) {
		if (x == 3) return x;
    	int nextX = x;
    	for (int i = x + 1; i < 4; i++) {				//find the farthest possible empty cell in that row
    		if (boardData[i][y] == null) nextX = i;
    	}
    	if (nextX == 3) return nextX;					//if the cell is at the farthest end, return that
    	else if (boardData[x][y].equals(boardData[nextX+1][y])) return nextX+1; //if the cell after the furthest available is a match, take that as next cell
    	else return nextX; //return if not at the end or not a match
	}
}
