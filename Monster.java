/**

Abstrakt klasse som representerer en monster i spillet.

Monsteret har posisjon, størrelse og hastighet.

Monsteret kan bevege seg mot et mål og sjekke om det kolliderer med en rektangel.
*/

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Monster {
    protected int x;
    protected int y;
    protected int size;
    protected int speed;
  

    public Monster(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
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

    protected abstract void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls);
}
