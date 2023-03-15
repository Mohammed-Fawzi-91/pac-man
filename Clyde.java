/**

Clyde er en subklasse av Monster som representerer spøkelset Clyde i spillet Pac-Man.
Clyde beveger seg på en lignende måte som de andre spøkelsene i spillet,
men har en tilfeldig variabel sjekk for å avgjøre hvilken bevegelsesalgoritme som skal brukes.
Hvis sjekk er mindre enn 1, beveger Clyde seg mot målet i x- eller y-retningen, avhengig av om
målet er mer horisontalt eller vertikalt fjernt fra Clyde. Hvis sjekk er større eller lik 1,
beveger Clyde seg mot et punkt som ligger to firkanter foran Pac-Man i den retningen Pac-Man beveger seg.
Hvis Clyde ikke kan bevege seg i x- eller y-retningen, vil han bevege seg i den andre retningen hvis mulig.
*/





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


    /**
 * Tegner Clyde på gitt Graphics2D-objekt.
 * 
 * @param g2d Graphics2D-objektet som Clyde skal tegnes på
 */
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }


/**
 * Beveger Clyde mot gitt mål i spillet, mens han unngår å kollidere med vegger.
 * 
 * @param targetX x-koordinatet til målet
 * @param targetY y-koordinatet til målet
 * @param walls   en ArrayList av Rectangle-objekter som representerer veggene i spillet
 */
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
        
       
         int dx = targetX - x;
         int dy = targetY - y;
         int px, py; 
         
         if (Math.abs(dx) > Math.abs(dy)) {
           
             px = targetX + dx / Math.abs(dx) * size * 2; 
             py = targetY;
         } else {
          
             px = targetX;
             py = targetY + dy / Math.abs(dy) * size * 2; 
         }
         
        
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

    

