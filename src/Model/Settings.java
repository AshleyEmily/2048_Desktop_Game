package Model;

import java.awt.*;

/*
 * 
 * 
 * 
 */
public class Settings {
	private int theme;
	public Color[] theme1;
	private String[] theme2;
	private String[] theme3;

	public Settings() {
		theme = 1;
		// {name, color1, color2, color3, color4}??
		theme1 = new Color[] {Color.BLUE, Color.CYAN};
// 		theme1 = new String[] {"#eee4da", "#ede0c8", "#f2b179", "#f59563", "#F67C5F", "#F65E3B", "#EDCF72", "#EDCC61", "#EDC850", "#EDC53F", "#EDC22E"};
        
		theme2 = new String[] {"#eee4da", "#ede0c8", "#99FEFF", "#94DAFF", "#94B3FD", "#B983FF","#DADDFC","#BEAEE2","#CAB8FF","#39A2DB","#5C7AEA"};
        
t		heme3 = new String[] {"#eee4da", "#ede0c8", "#9DD1AF", "#9BB494", "#68AB7A", "#628A6D", "#CCEFA5", "#ACCB8A", "#6BDB7D", "#ADF4B2", "#28D23F"};
	}

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
	public Color[] getTheme() {
		switch(theme){
		case 1: return theme1;
//		case 2: return theme2;
//		case 3: return theme3;
		default:
			break;
		}
		return theme1;
	}

	public int getThemeNumber() {
		return theme;
	}
}

//package Model;
///*
// * 
// * 
// * 
// */
//public class Settings {
//	private int theme = 1;
//	private String [] theme1 = new String[5];
//	private String [] theme2 = new String[5];
//	private String [] theme3 = new String[5];
//
//	/*
//	 * @param choice of theme (integer)
//	 * @return the String array of color codes
//	 */
//	public String [] getTheme(int choice) {
//		switch(choice) {
//		case 1: theme = 1;
//				return theme1;
//		case 2: theme = 2;
//				return theme2;
//		case 3: theme = 3;
//				return theme3;
//		default:
//			break;
//		}
//		return new String[5];
//	}
//	
//}
