/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pac.man;

/**
 *
 * @author mohammed
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class PacMan extends Application {

    private Player player;

    @Override
    public void start(Stage primaryStage) {

        // Create a pane to hold nodes
        StackPane pane = new StackPane();

        // Create a player
        player = new Player(0, 0, 15);

        // Add the player to the pane
        pane.getChildren().add(player);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);

        // Set the focus on the scene to receive key events
      scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    player.moveUp();
                    break;
                case DOWN:
                    player.moveDown();
                    break;
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveRight();
                    break;
            }
     
   // System.out.println("Player position: x=" + player.getX() + ", y=" + player.getY());
});

        primaryStage.setTitle("Pac Man");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set the focus on the scene to receive key events
    
    }

    public static void main(String[] args) {
        launch(args);
    }
}
