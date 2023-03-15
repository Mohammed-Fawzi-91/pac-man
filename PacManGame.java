/**

PacManGame er klassen som inneholder informasjon om vegger og prikker på PacMan-spillekartet.

Denne klassen har funksjoner for å tegne kartet og tilstanden til spillet.
*/



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javafx.scene.text.Font;
/**

Konstruktøren til PacManGame-klassen.

Her defineres veggene og prikkene på spillekartet.
*/
public class PacManGame {
    private ArrayList<Rectangle> walls;
    private ArrayList<Ellipse2D> dots;

    public PacManGame() {
        walls = new ArrayList<Rectangle>();
        dots = new ArrayList<Ellipse2D>();
        // Define the walls of the map
       
        walls.add(new Rectangle(0, 0, 20, 600));
        walls.add(new Rectangle(20,0 , 800, 20));
      walls.add(new Rectangle(20, 580, 800, 20));

        walls.add(new Rectangle(780, 20, 20, 600));
        
        walls.add(new Rectangle(300, 200, 200, 50));
        walls.add(new Rectangle(300, 350, 200, 50));
        walls.add(new Rectangle(200, 150, 50, 250));
        walls.add(new Rectangle(550, 150, 50, 250));
        walls.add(new Rectangle(100, 100, 50, 50));
        walls.add(new Rectangle(650, 100, 50, 50));
        walls.add(new Rectangle(100, 450, 50, 50));
        walls.add(new Rectangle(650, 450, 50, 50));

      
        int dotSize = 10;
        int dotSpacing = 30;
        for (int x = dotSpacing; x < 800 - dotSpacing; x += dotSpacing) {
            for (int y = dotSpacing; y < 600 - dotSpacing; y += dotSpacing) {
                Ellipse2D dot = new Ellipse2D.Double(x - dotSize / 2, y - dotSize / 2, dotSize, dotSize);
                if (!collidesWithWall(dot)) {
                    dots.add(dot);
                }
            }
        }
    }

    private boolean collidesWithWall(Ellipse2D dot) {
        for (Rectangle wall : walls) {
            if (dot.intersects(wall)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2d, int level) {
        // Set black background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 800, 600);

        // Draw  dots
        g2d.setColor(Color.YELLOW);
        for (Ellipse2D dot : dots) {
            g2d.fill(dot);
        }

        // Draw vegger
        g2d.setColor(Color.BLUE);
        for (Rectangle wall : walls) {
            g2d.fill(wall);
        }
    }
    public void drawGameOver(Graphics2D g2d, int level, int score) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 800, 600);
        g2d.setColor(Color.WHITE);
        
      
        java.awt.Font font = g2d.getFont().deriveFont(32f);
        g2d.setFont(font);
        
        g2d.drawString("Level: " + level, 360, 300);
        g2d.drawString("Score: " + score, 360, 340);
    }
    

    public ArrayList<Rectangle> getWalls() {
        return walls;
    }

    public ArrayList<Ellipse2D> getDots() {
        return dots;
    }

    public void drawMissedLive(Graphics2D g2d,int live) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 300, 800, 60);
        g2d.setColor(Color.WHITE);
        
       
        java.awt.Font font = g2d.getFont().deriveFont(32f);
        g2d.setFont(font);
        
        g2d.drawString("live: " + live, 360, 340);
    }
}
