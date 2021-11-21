package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Model extends JFrame implements KeyListener {
	
	Board game;
	
	Model(){
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
	            	//call board move methods moveUp()

	                break;

	            case KeyEvent.VK_DOWN:
	            	game.moveDown();
	                break;

	            case KeyEvent.VK_RIGHT:
	            	game.moveRight();
	                break;

	            case KeyEvent.VK_LEFT:
	            	game.moveLeft();
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

	

}
