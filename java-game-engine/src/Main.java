import gameEngine.*;

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args){
//        Pong.Window window = new Pong.Window();
//        Thread t1 = new Thread(window);
//        t1.start();

        Rect objeto1 = new Rect(10,5,20,10,'#');
        Control controlRect1 = new  Control(objeto1, KeyEvent.VK_DOWN,KeyEvent.VK_UP,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,true);

        Rect objeto2 = new Rect(20,20,5,5,'@');
        Control controlRect2 = new  Control(objeto2, KeyEvent.VK_S,KeyEvent.VK_W,KeyEvent.VK_D,KeyEvent.VK_A,true);

        Triangle objeto3 = new Triangle(5, 5, 3, '*');
        Triangle objeto4 = new Triangle(6, 7, 5, '*');

        Circle objeto5 = new Circle(1, 1, 3, '&');
        Circle objeto6 = new Circle(30, 30, 5, '%');

        Control[] controllers = new Control[2];
        controllers[0] = controlRect1;
        controllers[1] = controlRect2;

        Rect[] rects = new Rect[2];
        rects[0] = objeto1;
        rects[1] = objeto2;

        Triangle[] triangles = new Triangle[2];
        triangles[0] = objeto3;
        triangles[1] = objeto4;

        Circle[] circles = new Circle[2];
        circles[0] = objeto5;
        circles[0] = objeto6;


        GameEngine gm = new GameEngine(controllers,rects, triangles, circles);
        Thread t1 = new Thread(gm);
        t1.start();
    }
}
