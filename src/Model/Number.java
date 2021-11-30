package Model;

import java.awt.Point;

public class Number extends Settings{
	private int numValue;
	private int xCoord;
	private int yCoord;
	private static final int CELL_WIDTH = 120;
    private Point cellLocation;

	
	public Number(int x, int y){
		numValue = 2;
		xCoord = x;
		yCoord = y; 
		setCellLocation(x, y);
	}
	
	public void moveToNewPlace(int x, int y) { //set new Coordinates
		xCoord = x;
		yCoord = y;
		setCellLocation(x, y);
	}
	public int getXcoord() {
		return xCoord;
	}
	public int getYcoord() {
		return yCoord;
	}
	
	public static int getCellWidth() {
        return CELL_WIDTH;
    }
	
	public void setCellLocation(int x, int y) {
        setCellLocationPoint(new Point(x, y));
    }
	
	public void setCellLocationPoint(Point cellLocation) {
        this.cellLocation = cellLocation;
    }
	
	public int getNumValue() {
		return numValue;
	}
	public void updateNumber() { //set new NumValue
		numValue += numValue;
	}
	public boolean equals(Number that) {
		return (that.numValue == this.numValue);
	}



}
