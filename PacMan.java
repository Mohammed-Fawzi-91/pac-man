import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Representerer karakteren PacMan i  spillet.
 */
public class PacMan {
    private int x;
    private int y;
    private int speed;
    private Color color = Color.YELLOW;
    private int prevX,prevY;




    /**
     * Oppretter en ny instans av PacMan med gitt x- og y-koordinat og hastighet.
     * Fargen blir satt til gult som standard.
     * 
     * @param x     x-koordinatet til PacMan
     * @param y     y-koordinatet til PacMan
     * @param speed   hastigheten til pacMan
     * */
    public PacMan(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = Color.YELLOW; 
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    

    public void moveUp(ArrayList<Rectangle> walls) {
        prevX = x;
        prevY = y;

        y -= speed;
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                y = prevY;
                break;
            }
        }
    }

    public void moveDown(ArrayList<Rectangle> walls) {
        prevX = x;
        prevY = y;
        y += speed;
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                y = prevY;
                break;
            }
        }
    }

    public void moveLeft(ArrayList<Rectangle> walls) {
        prevX = x;
        prevY = y;
    
        x -= speed;
    
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                x = prevX;
                break;
            }
        }
    }

    public void moveRight(ArrayList<Rectangle> walls) {
        prevX = x;
        prevY = y;
    

        x += speed;
    

        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                x = prevX;
                break;
            }
        }
    }

   
// Returnerer en rektangel som representerer PacMans område.
    public Rectangle getBounds() {
        return new Rectangle(x, y, 28, 28);
    }

    public void update(Keyboard keyboard, ArrayList<Rectangle> walls) {
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
    
        for (Rectangle wall : walls) {
            if (getBounds().intersects(wall)) {
                x = prevX;
                y = prevY;
                break;
            }
        }
    
        prevX = x;
        prevY = y;
    
 
    }
    
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
    
        g2d.fillArc(x, y, 30, 30, 45, 270);
    }
    

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    public void setY() {
      y = 300;
    }
    public void setX() {
        x = 400;
      }

  //Sjekker om PacMan kolliderer med en gitt rektangel.
    public boolean intersects(Rectangle2D rectangle2d) {
        return getBounds().intersects(rectangle2d);
    }


  
    
   
}
