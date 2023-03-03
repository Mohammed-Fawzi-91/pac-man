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

class Player extends Circle {

    private double x;
    private double y;
   // Color color = new Color(27.0, 225.0, 0.0, 0.1);

    public Player(double x, double y, double radios) {
        super(x, y, radios);
                setFill(Color.YELLOW);
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        animateMove(y - 13, x);
        y -= 13;
    }

    public void moveDown() {
        animateMove(y + 13, x);
        y += 13;
    }

    public void moveLeft() {
        animateMove(y, x - 13);
        x -= 13;
    }

    public void moveRight() {
        animateMove(y, x + 13);
        x += 13;
    }

    private void animateMove(double targetY, double targetX) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(0.1),
                event -> {
                    setTranslateX(targetX);
                    setTranslateY(targetY);
                    setCenterX(targetX);
                    setCenterY(targetY);
                }));
        timeline.play();
    }
}
