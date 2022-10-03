package gameEngine;

import javax.swing.*;
import java.awt.*;

public class Draw {
    private JTextArea asciiDisplay = new JTextArea();
    private int width,height;


    Draw(JFrame frame){
        this.width = Constants.PIXELS_WIDTH;
        this.height = Constants.PIXELS_HEIGHT;

        this.asciiDisplay.setFont(new java.awt.Font(Constants.fontName, Font.BOLD, 10));
        frame.add(asciiDisplay);
        asciiDisplay.addKeyListener(frame.getKeyListeners()[0]);
    }

    public void drawPixels(Pixels pixels){
        StringBuilder txt = new StringBuilder();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                txt.append(pixels.matrix[i][j]);
            }
            txt.append('\n');
        }

        this.asciiDisplay.setText(txt.toString());
    }
    public void clearPixels(Pixels pixels){
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                pixels.matrix[i][j] = '.';

    }

    public void drawRect(Pixels pixels,int x, int y,int width, int height, char texture){
        if (x < 0) return;
        if (y < 0) return;
        if (x+width > this.width) return;
        if (y+height > this.height) return;

        for (int i = y; i < y+height; i++) {
            for (int j = x; j < x+width; j++) {
                pixels.matrix[i][j] = texture;
            }
        }
    }
    public void drawRect(Pixels pixels,Rect rect){
        if (rect.x < 0) return;
        if (rect.y < 0) return;
        if (rect.x+rect.width > this.width) return;
        if (rect.y+rect.height > this.height) return;

        for (int i = rect.y; i < rect.y+rect.height; i++) {
            for (int j = rect.x; j < rect.x+rect.width; j++) {
                pixels.matrix[i][j] = rect.texture;
            }
        }
    }


    public static void drawPosition(int x, int y, Pixels pixels, char texture){
        pixels.matrix[x][y] = texture;
    }


    public void drawTriangle(Pixels pixels, Triangle triangle){
        if (triangle.x < 0) return;
        if (triangle.y < 0) return;
        if (triangle.x+triangle.base > this.width) return;
        if (triangle.y+triangle.base > this.height) return;

        int x = triangle.x;

        for(int i = 1; i <= triangle.base; i++)
        {
            for(int j = 1; j <= triangle.base - i; j++)
            {
                pixels.matrix[x][triangle.y] = ' ';
                x++;
            }
            for(int k = 1; k <= i; k++)
            {
                pixels.matrix[x][triangle.y] = triangle.texture;
                x++;
            }
            for(int l = i - 1; l >= 1; l--)
            {
                pixels.matrix[x][triangle.y] = triangle.texture;
                x++;
            }
            x = triangle.x;
            triangle.y++;
        }
    }
    public void drawCircle(Pixels pixels, Circle circle){
        double dist;

        for (int i = 0; i <= 2 * circle.rad; i++) {
            for (int j = 0; j <= 2 * circle.rad; j++) {
                dist = Math.sqrt((i - circle.rad) * (i - circle.rad) + (j - circle.rad) * (j - circle.rad));
                if (dist > circle.rad - 0.5 && dist < circle.rad + 0.5)
                    pixels.matrix[circle.x][circle.y] = circle.texture;
                else
                    pixels.matrix[circle.x][circle.y] = ' ';
            }
        }
    }
}
