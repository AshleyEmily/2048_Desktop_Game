package Model;

/*
 * 
 * 
 * 
 */
public class Settings {
	private int theme = 1;
	public String[] theme1 = new String[] {"#eee4da", "#ede0c8", "#f2b179", "#f59563", "#F67C5F", "#F65E3B", "#EDCF72", "#EDCC61", "#EDC850", "#EDC53F", "#EDC22E"};

	private String[] theme2 = new String[] {"#eee4da", "#ede0c8", "#99FEFF", "#94DAFF", "#94B3FD", "#B983FF","#DADDFC","#BEAEE2","#CAB8FF","#39A2DB","#5C7AEA"};

	private String[] theme3 =  new String[] {"#eee4da", "#ede0c8", "#9DD1AF", "#9BB494", "#68AB7A", "#628A6D", "#CCEFA5", "#ACCB8A", "#6BDB7D", "#ADF4B2", "#28D23F"};

	/**
	 * Method which sets theme based on an integer.
	 * @param choice of theme (integer) 
	 */
	public void setTheme(int choice) {
		theme = choice;
	}
	
	/**
	 * Method that returns the theme based on the set integer theme.
	 * @return one of themes 1 to 3
	 */
	public String[] getTheme() {
		switch(theme){
		case 1: return theme1;
		case 2: return theme2;
		case 3: return theme3;
		default:
			break;
		}
		return theme1;
	}

	public int getThemeNumber() {
		return theme;
	}
}

