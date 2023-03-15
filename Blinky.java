
/**

Denne klassen representerer Blinky-monsteret i Pac-Man-spillet.

Blinky er det røde monsteret og hans hovedstrategi er å bevege seg mot Pac-Man.

Denne klassen utvider den abstrakte klassen Monster og implementerer dens abstrakte metoder.
*/

import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;


public class Blinky extends Monster {

    /**
    
    The color of Blinky.
    */
    private static final Color color = Color.RED;
    /**
    
  Konstruerer et Blinky-objekt med spesifisert posisjon, størrelse og hastighet.
     @param x x-koordinaten til Blinkys posisjon.
     @param y Y-koordinaten til Blinkys posisjon.
     @param størrelse Størrelsen på Blinky.
     @param speed Hastigheten til Blinky.
     */

    public Blinky(int x, int y, int size, int speed) {
    super(x, y, size, speed);
    }
    /**
    
    Draws Blinky .
 
    */
    public void draw(Graphics2D g2d) {
    g2d.setColor(color);
    g2d.fillOval(x, y, size, size);
    }
/**
    
     Flytter Blinky mot den angitte målposisjonen mens du unngår vegger.
    
     @param targetX x-koordinaten til målposisjonen.
    
     @param targetY Y-koordinaten til målposisjonen.
    
     @param vegger Listen over vegger som Blinky må unngå.
     */
    @Override
    protected void moveTowards(int targetX, int targetY, ArrayList<Rectangle> walls) {
    int dx = targetX - x;
    int dy = targetY - y;
    
    // Check hvis Pac-Man er høyre eller venstre 
    if (dx > 0) {
    dx = speed;
    } else if (dx < 0) {
    dx = -speed;
    }
    
    if (dy > 0) {
    dy = speed;
    } else if (dy < 0) {
    dy = -speed;
    }
 
    Rectangle potentialMove = new Rectangle(x + dx, y + dy, size, size);
    for (Rectangle wall : walls) {
    if (potentialMove.intersects(wall)) {
    return;
    }
    }
    
    x += dx;
    y += dy;
    }
    
    }
