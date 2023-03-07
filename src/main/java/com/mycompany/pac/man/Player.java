/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pac.man;

/**
 *
 * @author mohammed
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player extends Circle {
    private double x;
    private double y;
    private MapReader mapReader;

    public Player(double radius, MapReader mapReader) {
        super(50, 70, radius);
        setFill(Color.YELLOW);
        this.x = 50;
        this.y = 70;
        this.mapReader = mapReader;
    }

    public void moveUp() {
        animateMove(y - 10, x);
        y -= 10;
    }

    public void moveDown() {
        animateMove(y + 10, x);
        y += 10;
    }

    public void moveLeft() {
        animateMove(y, x - 10);
        x -= 10;
    }

    public void moveRight() {
        animateMove(y, x + 10);
        x += 10;
        
    }

   

    private void animateMove(double targetY, double targetX) {
        if (!mapReader.isWhitePixel(targetX, targetY)) { // Check if the next position is white
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(0.1),
                    event -> {
                        setTranslateX(targetX);
                        setTranslateY(targetY);
                        setCenterX(targetX);
                        setCenterY(targetY);
                        System.out.println(x + "  " + y);
                    }));
    
            timeline.play();
            x = targetX;
            y = targetY;
        }
    }
}
