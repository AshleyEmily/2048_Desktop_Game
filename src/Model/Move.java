package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {
    public Move() {

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

                break;

            case KeyEvent.VK_DOWN:

                break;

            case KeyEvent.VK_RIGHT:

                break;

            case KeyEvent.VK_LEFT:

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
