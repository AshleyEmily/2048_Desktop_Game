package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Model extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	Board game;
	
	public Model(){
		game = new Board();
        addKeyListener(this);
	}
	
	 @Override
	    public void keyTyped(KeyEvent e) {
	        // invalid
	    }

	    /**
	     * @Override
	     * input key action and reflect based on the input.
	     * */
	    public void keyPressed(KeyEvent e) {
	        int keyCode = e.getKeyCode();

	        switch (keyCode){
	            case KeyEvent.VK_UP:
	            	game.moveUp();
	            	game.populateTiles();
	                break;

	            case KeyEvent.VK_DOWN:
	            	game.moveDown();
	            	game.populateTiles();
	                break;

	            case KeyEvent.VK_RIGHT:
	            	game.moveRight();
	            	game.populateTiles();
	                break;

	            case KeyEvent.VK_LEFT:
	            	game.moveLeft();
	            	game.populateTiles();
	                break;

	            default:
	                break;
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {

	    }

	    public void setVisible(boolean b) {
	    }
	    
	    
	    public void setTheme(int choice) {
	    	game.changeTheme(choice);
	    }
	    public String[] getTheme() {
	    	return game.getThemeSettings().getTheme();
	    }
	    
	    
	    public int getScore() {
	    	return game.getGameScore().getScore();
	    }
	    
	    public int getHighScore() {
	    	return game.getGameScore().getHighScore();
	    }
	   
//	    public static void main(String [] args) {
//	    	Model start = new Model();
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	start.game.moveUp();
//	    	start.game.populateTiles();
//    		System.out.println("\n");
//
//	    	
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	start.game.moveLeft();
//	    	start.game.populateTiles();
//	    	
//    		System.out.println("\n");
//
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    	
//	    	start.game.moveRight();
//	    	start.game.populateTiles();
//	    	
//	    	for (int x = 0; x < 4; x++)
//	    	{
//	    		for (int y = 0; y < 4; y++) {
//	    			if (start.game.getTile(x, y) != null) {
//		    	    	System.out.print(" " + start.game.getTile(x, y).getNumValue() + " ");
//	    			}
//	    			else System.out.print(" _ ");
//
//	    		}
//	    		System.out.println("\n");
//	    	}
//	    }

}
