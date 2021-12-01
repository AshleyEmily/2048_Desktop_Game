package Model;

import Controller.Settings;

public class Number extends Settings {
	private int numValue;
	private int xCoord;
	private int yCoord;
	private static final int CELL_WIDTH = 120;

	
	public Number(int x, int y){
		numValue = 2;
		xCoord = x;
		yCoord = y; 
	}
	
	public void moveToNewPlace(int x, int y) { //set new Coordinates
		xCoord = x;
		yCoord = y;
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

