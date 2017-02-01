package game;
import units.Platform;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//This is the input handler class. We will extend it later with movement commands for the platform.
public class InputHandler implements KeyListener {

    private boolean exitMenu;

    public InputHandler(Canvas canvas) {
        canvas.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code=e.getKeyCode();

        if(code==KeyEvent.VK_ENTER){
         this.exitMenu=true;
        }

        //Implementing platform's moving
        if (code == KeyEvent.VK_RIGHT){
            Platform.isMovingRight = true;
            Platform.isMovingLeft = false;
        } else if (code == KeyEvent.VK_LEFT){
            Platform.isMovingRight = false;
            Platform.isMovingLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();

        if (code == KeyEvent.VK_RIGHT){
            Platform.isMovingRight = false;
            Platform.isMovingLeft = false;
        } else if (code == KeyEvent.VK_LEFT){
            Platform.isMovingRight = false;
            Platform.isMovingLeft = false;
        }
    }

    public boolean isMenuModeOn(){

        if(this.exitMenu) return false;
        else return true;
    }
}
