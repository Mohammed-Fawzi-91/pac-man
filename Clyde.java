
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;

public class Clyde extends Monster {
 
    static private Color color = Color.ORANGE;
    double check; 

    
 
  

    public Clyde(int x, int y, int size, int speed) {
        super(x, y, size, speed);
        
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }
    @Override
    protected void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls) {
        check = Math.random()*2;
        System.out.println(check);
        if(check < 1){
      
        int dx = Integer.compare(targetX, x);
        int dy = Integer.compare(targetY, y);
    
        Rectangle potentialXMove = new Rectangle(x + dx * speed, y, size, size);
        boolean canMoveX = true;
        for (Rectangle wall : walls) {
            if (potentialXMove.intersects(wall)) {
                canMoveX = false;
                break;
            }
        }
    
        Rectangle potentialYMove = new Rectangle(x, y + dy * speed, size, size);
        boolean canMoveY = true;
        for (Rectangle wall : walls) {
            if (potentialYMove.intersects(wall)) {
                canMoveY = false;
                break;
            }
        }
    
        if (canMoveX && (dx != 0 || !canMoveY)) {
            x += dx * speed;
        } else if (canMoveY) {
            y += dy * speed;
        }
    }else {
        
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
     

}}

    

