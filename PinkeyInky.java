
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;

public class PinkeyInky extends Monster {
 
     private Color color;

    
 
  

    public PinkeyInky(int x, int y, int size, int speed,Color color) {
        super(x, y, size, speed);
        this.color= color;
        
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }
  
    @Override
    protected void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls) {
        // Implementation of moveTowards() specific to PinkeyInky
        int dx = targetX - x;
        int dy = targetY - y;
        int px, py; // position to aim for
        
        if (Math.abs(dx) > Math.abs(dy)) {
            // Pac-Man is more horizontally distant
            px = targetX + dx / Math.abs(dx) * size * 2; // aim two squares ahead
            py = targetY;
        } else {
            // Pac-Man is more vertically distant
            px = targetX;
            py = targetY + dy / Math.abs(dy) * size * 2; // aim two squares ahead
        }
        
        // Try to move towards the target position
        int dirX = Integer.compare(px, x);
        int dirY = Integer.compare(py, y);
    
        Rectangle potentialXMove = new Rectangle(x + dirX * speed, y, size, size);
        boolean canMoveX = true;
        for (Rectangle wall : walls) {
            if (potentialXMove.intersects(wall)) {
                canMoveX = false;
                break;
            }
        }
    
        Rectangle potentialYMove = new Rectangle(x, y + dirY * speed, size, size);
        boolean canMoveY = true;
        for (Rectangle wall : walls) {
            if (potentialYMove.intersects(wall)) {
                canMoveY = false;
                break;
            }
        }
    
        if (canMoveX && (dirX != 0 || !canMoveY)) {
            x += dirX * speed;
        } else if (canMoveY) {
            y += dirY * speed;
        }
    }
    


}
