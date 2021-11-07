package Model;

public class SeekCellsContext {
	private seekCells methods;
	
	public SeekCellsContext(seekCells methods) {
		this.methods = methods;
	}
	
	public int executeMethod(int x, int y, Number[][] board) {
		return methods.findNextAvailable(x, y, board);
	}
}
