package Model;

public class Number{
	private int numValue;
	private int xCoord;
	private int yCoord;
	private String color;
	
	public Number(int x, int y, String color){
		numValue = 2;
		xCoord = x;
		yCoord = y;
		this.color = color; 
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
	
	
	public int getNumValue() {
		return numValue;
	}
	public void updateNumber() { //set new NumValue
		numValue += numValue;
	}
	public boolean equals(Number that) {
		return (that.numValue == this.numValue);
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	

}
