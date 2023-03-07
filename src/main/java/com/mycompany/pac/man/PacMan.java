package com.mycompany.pac.man;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PacMan extends Application {
     private MapReader mapReader;

    private Player player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Read the map image from file
        MapReader reader = new MapReader("map.png");
        mapReader = new MapReader("map.png");


        
        Image imag = reader.getImage();
        BufferedImage mapImage = SwingFXUtils.fromFXImage(imag, null);
        // Create a pane to hold nodes
        StackPane pane = new StackPane();

        // Create a player
        player = new Player(10, mapReader);
        player.setTranslateX(50);
        player.setTranslateY(70);

        // Add the player to the pane

        // Create a group to hold the map image and rectangles
        Image image = new Image("file:map.png");
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

        Rectangle mapBackground = new Rectangle(0, 0, 600, 600);
        mapBackground.setFill(new ImagePattern(SwingFXUtils.toFXImage(bufferedImage, null)));
                pane.getChildren().add(mapBackground);

        Group mapGroup = new Group();

        /*  Add the map rectangles to the group
        Circle[][] mapCircles = reader.getCircles();
        for (int i = 0; i < mapCircles.length; i++) {
            for (int j = 0; j < mapCircles[i].length; j++) {
                if (mapCircles[i][j] != null) {
                    mapGroup.getChildren().add(mapCircles[i][j]);
                }
            }
        }

        // Add the group to the pane
        pane.getChildren().add(mapGroup);

        */
        pane.getChildren().add(player);


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 600);

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
        });

        primaryStage.setTitle("Pac Man");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
