/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pac.man;

/**
 *
 * @author mohammed
 */
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.image.BufferedImage;

public class MapDrawer {
    private BufferedImage image;
    public Rectangle[][] rectangles;

    public MapDrawer(BufferedImage image) {
        this.image = image;
        int width = image.getWidth();
        int height = image.getHeight();
        rectangles = new Rectangle[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rectangles[x][y] = new Rectangle(x, y, 1, 1);
                int pixel = image.getRGB(x, y);
                Color color = Color.rgb(
                        (pixel >> 16) & 0xFF,
                        (pixel >> 8) & 0xFF,
                        pixel & 0xFF
                );
                rectangles[x][y].setFill(color);
            }
        }
    }
}