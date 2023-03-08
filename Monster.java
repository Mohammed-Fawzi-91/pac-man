import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Monster {
    private int x;
    private int y;
    private int size;
    private int speed;
    private Color color;

    public Monster(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = 1;
        this.color = Color.RED;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }

    public void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls) {
        // Calculate the direction to move in
        int dx = Integer.compare(targetX, x);
        int dy = Integer.compare(targetY, y);
    
        // Check if moving in the x direction is possible
        Rectangle potentialXMove = new Rectangle(x + dx * speed, y, size, size);
        boolean canMoveX = true;
        for (Rectangle wall : walls) {
            if (potentialXMove.intersects(wall)) {
                canMoveX = false;
                break;
            }
        }
    
        // Check if moving in the y direction is possible
        Rectangle potentialYMove = new Rectangle(x, y + dy * speed, size, size);
        boolean canMoveY = true;
        for (Rectangle wall : walls) {
            if (potentialYMove.intersects(wall)) {
                canMoveY = false;
                break;
            }
        }
    
        // Move in the direction that is possible
        if (canMoveX && (dx != 0 || !canMoveY)) {
            x += dx * speed;
        } else if (canMoveY) {
            y += dy * speed;
        }
    }
    

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public boolean intersects(Rectangle rectangle) {
        return getBounds().intersects(rectangle);
    }

    public void update(int targetX, int targetY, ArrayList<Rectangle> walls) {
        moveTowards(targetX, targetY, walls);
    }

    
}
