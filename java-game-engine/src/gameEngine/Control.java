package gameEngine;


import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;

public class Control {
    public Rect rect;
    public KL keyListener;
    public Collision collision;
    public int keyDown;
    public int keyUp;
    public int keyRight;
    public int keyLeft;
    public boolean hasCollision;

    public Control(Rect rect, int keyDown, int keyUp, int keyRight, int keyLeft, boolean hasCollision){
        this.rect = rect;

        this.keyDown = keyDown;
        this.keyUp = keyUp;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
        this.hasCollision = hasCollision;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
        this.hasCollision = true;
    }

    public void addEventListener(KL keyListener){
        this.keyListener = keyListener;
    }

    public void update(double dt){
        if(keyListener != null ){
            if(keyListener.isKeyPressed(this.keyDown)){ //KeyEvent.VK_DOWN
                this.moveDown(dt);
            }else if(keyListener.isKeyPressed(this.keyUp)){ //KeyEvent.VK_UP
                this.moveUp(dt);
            }else if (keyListener.isKeyPressed(this.keyRight)){
                this.moveRight(dt);
            }else if (keyListener.isKeyPressed(this.keyLeft)){
                this.moveLeft(dt);
            }
        }
    }
    public void moveUp(double dt){
        if (!this.hasCollision || this.collision.canMoveUp(this.rect)){
            this.rect.y--;
        }
    }
    public void moveDown(double dt){
        if (!this.hasCollision || this.collision.canMoveDown(this.rect)){
            this.rect.y++;
        }
    }
    public void moveRight(double dt){
        if (!this.hasCollision || this.collision.canMoveRight(this.rect)){
            this.rect.x++;
        }
    }
    public void moveLeft(double dt){
        if (!this.hasCollision || this.collision.canMoveLeft(this.rect)){
            this.rect.x--;
        }
    }
}
