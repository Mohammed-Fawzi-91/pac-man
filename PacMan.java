import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Color;


public class PacMan {
    private int x;
    private int y;
    private int speed;
    private Color color = Color.YELLOW;
    private int prevX,prevY;

    public PacMan(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void moveUp(ArrayList<Rectangle> walls) {
        // save previous position for collision detection
        prevX = x;
        prevY = y;
    
        // move Pac-Man up
        y -= speed;
    
        // check for collisions with walls
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                // move Pac-Man back to previous position
                y = prevY;
                break;
            }
        }
    }

    public void moveDown(ArrayList<Rectangle> walls) {
        // save previous position for collision detection
        prevX = x;
        prevY = y;
    
        // move Pac-Man up
        y += speed;
    
        // check for collisions with walls
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                // move Pac-Man back to previous position
                y = prevY;
                break;
            }
        }
    }

    public void moveLeft(ArrayList<Rectangle> walls) {
        // save previous position for collision detection
        prevX = x;
        prevY = y;
    
        // move Pac-Man up
        x -= speed;
    
        // check for collisions with walls
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                // move Pac-Man back to previous position
                x = prevY;
                break;
            }
        }
    }

    public void moveRight(ArrayList<Rectangle> walls) {
        // save previous position for collision detection
        prevX = x;
        prevY = y;
    
        // move Pac-Man up
        x += speed;
    
        // check for collisions with walls
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                // move Pac-Man back to previous position
                x = prevY;
                break;
            }
        }
    }

   

    public Rectangle getBounds() {
        // return bounding box for Pac-Man character
        return new Rectangle(x, y, 20, 20);
    }

    public void update(Keyboard keyboard, ArrayList<Rectangle> walls) {
        // check for user input and update Pac-Man's position
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
            moveUp(walls);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
            moveDown(walls);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
            moveLeft(walls);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
            moveRight(walls);
        }
    
        // check for collisions with walls
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                // move Pac-Man back to previous position
                x = prevX;
                y = prevY;
                break;
            }
        }
    
        // save current position for collision detection in next frame
        prevX = x;
        prevY = y;
    
       
    }
    
    public void draw(Graphics2D g2d) {
        // set the color to yellow
        g2d.setColor(color);
    
        // draw the Pac-Man character as an arc
        g2d.fillArc(x, y, 20, 20, 45, 270);
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public boolean intersects(Rectangle bounds) {
        return false;
    }

    
    
   
}
