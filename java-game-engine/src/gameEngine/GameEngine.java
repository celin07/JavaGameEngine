package gameEngine;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameEngine extends JFrame implements Runnable {
    public KL keyListener = new KL();
    public Draw drawModule;
    public Control[] controllers;
    public Rect[] rects;
    public Circle[] circles;
    public Triangle[] triangles;
    public Pixels pixels = new Pixels();
    public int width,height;
    public int count=0;

    public GameEngine(Control[] controllers,Rect[] rects, Triangle[] triangles, Circle[] circles){
        this.width = Constants.SCREEN_WIDTH;
        this.height = Constants.SCREEN_HEIGHT;

        this.controllers = controllers;

        for (int i = 0; i < controllers.length; i++){
            controllers[i].addEventListener(this.keyListener);
            if (controllers[i].hasCollision){
                controllers[i].setCollision(new Collision(this.pixels));
            }
        }



        this.rects = rects;
        this.triangles = triangles;
        this.circles = circles;

        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this.keyListener);

        this.drawModule = new Draw(this);
        this.setVisible(true);
    }


    private void update(double dt){
        drawModule.clearPixels(this.pixels);
        for (int i = 0; i < this.rects.length; i++) {
            drawModule.drawRect(this.pixels,this.rects[i]);
            drawModule.drawTriangle(this.pixels, this.triangles[i]);
            drawModule.drawCircle(this.pixels, this.circles[i]);
        }
        drawModule.drawPixels(this.pixels);

        for (int i = 0; i < controllers.length; i++)
            controllers[i].update(dt);
    }

    public void run() {
        double lastFrameTime = 0.0;
        while(true){
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
