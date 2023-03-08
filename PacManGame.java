import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class PacManGame {
    private ArrayList<Rectangle> walls;

    public PacManGame() {
        walls = new ArrayList<Rectangle>();
        // Define the walls of the map
        walls.add(new Rectangle(0, 0, 800, 20));
        walls.add(new Rectangle(0, 580, 800, 20));
        walls.add(new Rectangle(0, 0, 20, 600));
        walls.add(new Rectangle(780, 0, 20, 600));
        walls.add(new Rectangle(300, 200, 200, 50));
        walls.add(new Rectangle(300, 350, 200, 50));
        walls.add(new Rectangle(200, 150, 50, 250));
        walls.add(new Rectangle(550, 150, 50, 250));
        walls.add(new Rectangle(100, 100, 50, 50));
        walls.add(new Rectangle(650, 100, 50, 50));
        walls.add(new Rectangle(100, 450, 50, 50));
        walls.add(new Rectangle(650, 450, 50, 50));
    }

    public void draw(Graphics2D g2d) {
        // Set black background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 800, 600);
        
        // Draw the walls
        g2d.setColor(Color.BLUE);
        for (Rectangle wall : walls) {
            g2d.fill(wall);
        }
    }
    
    public ArrayList<Rectangle> getWalls() {
        return walls;
    }
}