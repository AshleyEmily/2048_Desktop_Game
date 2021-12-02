package Model;

public class Number{
	private int numValue;
	private static final int CELL_WIDTH = 120;

	
	public Number(){
		numValue = 2;
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

