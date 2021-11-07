package Model;
/*
 * 
 * 
 * 
 */
public class Settings {
	private int theme;
	private String[] theme1;
	private String[] theme2;
	private String[] theme3;

	public Settings() {
		theme = 1;
		// {name, color1, color2, color3, color4}??
		theme1 = new String[] {"Classic Theme", "Blue", "Green", "Yellow", "Red"};
		theme2 = new String[] {"Wood Theme", "Blue", "Green", "Yellow", "Red"};
		theme3 = new String[] {"Aqua Theme", "Blue", "Green", "Yellow", "Red"};
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
