package gameEngine;

public class Pixels {
    public char[][] matrix;
    public int width;
    public int height;
    Pixels(){
        char[][] matrix = new char[Constants.PIXELS_HEIGHT][Constants.PIXELS_WIDTH];
        this.width = Constants.PIXELS_WIDTH;
        this.height = Constants.PIXELS_HEIGHT;

        for (int i = 0; i < Constants.PIXELS_HEIGHT; i++)
            for (int j = 0; j < Constants.PIXELS_WIDTH; j++)
                matrix[i][j] = '_';

        this.matrix = matrix;
    }
}
