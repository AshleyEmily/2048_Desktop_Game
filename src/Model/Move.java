package Model;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move extends JFrame implements KeyListener {
    public Move() {
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
               // System.out.println("up");
                break;

            case KeyEvent.VK_DOWN:
               // System.out.println("down");
                break;

            case KeyEvent.VK_RIGHT:
                //System.out.println("right");
                break;

            case KeyEvent.VK_LEFT:
                //System.out.println("left");
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
