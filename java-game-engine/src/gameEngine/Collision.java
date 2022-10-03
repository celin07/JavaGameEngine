package gameEngine;

public class Collision {
    Pixels pixels;

    Collision(Pixels pixels){
        this.pixels = pixels;
    }

    private boolean BorderCollision(Rect rect){


        return true;
    }

    public boolean canMoveUp(Rect rect){
        if (rect.y <= 0) return false;

        for (int i = rect.x; i < rect.x+rect.width; i++) {
            if (this.pixels.matrix[rect.y-1][i] != '.'){
                return false;
            }
        }
        return true;
    }


    public boolean canMoveDown(Rect rect){
        if (rect.y+rect.height >= this.pixels.height) return false;


        for (int i = rect.x; i < rect.x+rect.width; i++) {
            if (this.pixels.matrix[rect.y+rect.height][i] != '.'){
                return false;
            }
        }
        return true;
    }

    public boolean canMoveRight(Rect rect){
        if (rect.x+rect.width >= this.pixels.width) return false;

        for (int i = rect.y; i < rect.y+rect.height; i++) {
             if (this.pixels.matrix[i][rect.x+rect.width] != '.'){
                return false;
            }
        }
        return true;
    }
    public boolean canMoveLeft(Rect rect){
        if (rect.x <= 0) return false;


        for (int i = rect.y; i < rect.y+rect.height; i++) {
            System.out.println("["+rect.x+"]["+i+"]");
            if (this.pixels.matrix[i][rect.x-1] != '.'){
                return false;
            }
        }
        return true;
    }

}
