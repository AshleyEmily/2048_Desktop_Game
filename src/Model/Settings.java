package Model;
/*
 * 
 * 
 * 
 */
public class Settings {
	private int theme = 1;
	private String [] theme1 = new String[5];
	private String [] theme2 = new String[5];
	private String [] theme3 = new String[5];

	/*
	 * @param choice of theme (integer)
	 * @return the String array of color codes
	 */
	public String [] getTheme(int choice) {
		switch(choice) {
		case 1: theme = 1;
				return theme1;
		case 2: theme = 2;
				return theme2;
		case 3: theme = 3;
				return theme3;
		default:
			break;
		}
		return new String[5];
	}
	
}
