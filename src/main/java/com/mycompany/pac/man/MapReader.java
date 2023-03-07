/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pac.man;

/**
 *
 * @author mohammed
 */
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapReader {
    public Image image;
    private boolean[][] whitePixels;

    public MapReader(String fileName) {
        try (InputStream stream = getClass().getResourceAsStream(fileName)) {
            image = new Image(stream);
        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
            e.printStackTrace();
        }
        readWhitePixels();
    }

    public Image getImage() {
        return image;
    }

    public Circle[][] getCircles() {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        Circle[][] circles = new Circle[width][height];
        PixelReader pixelReader = image.getPixelReader();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pixelReader.getColor(x, y);
                if (color.equals(Color.BLACK)) {
                    Circle circle = new Circle(5, Color.BLUE.deriveColor(1, 1, 1, 0.5));
                    circle.setTranslateX(x * 10);
                    circle.setTranslateY(y * 10);
                    circles[x][y] = circle;
                }
            }
        }
        return circles;
    }
    private void readWhitePixels() {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        whitePixels = new boolean[width][height];
        PixelReader pixelReader = image.getPixelReader();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pixelReader.getColor(x, y);
                whitePixels[x][y] = color.equals(Color.WHITE);
            }
        }
    }

    public boolean isWhitePixel(double x, double y) {
        int ix = (int) x;
        int iy = (int) y;
        if (ix < 0 || ix >= whitePixels.length || iy < 0 || iy >= whitePixels[0].length) {
            return false; // position is outside the map
        }
        return whitePixels[ix][iy];
    }
}
    
