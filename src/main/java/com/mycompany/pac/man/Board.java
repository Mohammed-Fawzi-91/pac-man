package com.mycompany.pac.man;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Board {
    private Color[][] colors;

    public Board(String imagePath) {
        Image image = new Image(imagePath);
        PixelReader reader = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        colors = new Color[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                colors[row][col] = reader.getColor(col, row);
            }
        }
    }

    public Color getColor(int row, int col) {
        return colors[row][col];
    }
}
