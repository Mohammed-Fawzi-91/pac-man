import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
        this.speed = 2;
        this.color = Color.RED;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }

    public void moveTowards(int targetX, int targetY) {
        if (x < targetX) {
            x += speed;
        } else if (x > targetX) {
            x -= speed;
        }
        if (y < targetY) {
            y += speed;
        } else if (y > targetY) {
            y -= speed;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public boolean intersects(Rectangle rectangle) {
        return getBounds().intersects(rectangle);
    }

    public void update(int targetX, int targetY) {
        moveTowards(targetX, targetY);
    }

    
}
