import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;

public class Blinky extends Monster {
    private static final Color color = Color.RED;

    public Blinky(int x, int y, int size, int speed) {
        super(x, y, size, speed);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }

   
    @Override
    protected void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls) {
        // Implementation of moveTowards() specific to Blinky
        int dx = targetX - x;
        int dy = targetY - y;
        
        // Check if Pac-Man is to the left or right of Blinky
        if (dx > 0) {
            dx = speed;
        } else if (dx < 0) {
            dx = -speed;
        }
        
        // Check if Pac-Man is above or below Blinky
        if (dy > 0) {
            dy = speed;
        } else if (dy < 0) {
            dy = -speed;
        }
        
        // Check if the potential move intersects with any walls
        Rectangle potentialMove = new Rectangle(x + dx, y + dy, size, size);
        for (Rectangle wall : walls) {
            if (potentialMove.intersects(wall)) {
                // If the potential move intersects with a wall, do not move
                return;
            }
        }
        
        // Move Blinky towards Pac-Man
        x += dx;
        y += dy;
    }
    
}
