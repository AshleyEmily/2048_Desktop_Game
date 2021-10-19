package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {
    public Move() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @Override
     * input key action and reflect based on the input.
     * */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_UP:

            case KeyEvent.VK_DOWN:

            case KeyEvent.VK_RIGHT:

            case KeyEvent.VK_LEFT:
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
