/**

The Game class implements a Pac-Man game with graphics.
It extends JPanel and implements ActionListener and KeyListener interfaces.
The game includes a Pac-Man character and 4 monsters, walls, dots, and fruits.
The game has 3 levels and 3 lives per level. The game ends if all lives are lost or all levels are completed.
@version 1.0

*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener, KeyListener {
    private PacMan pacMan;
    private Timer timer;
    private int level;
    private int score;
    private int life;
    private Keyboard keyboard;
    private PacManGame pacManGame;
    private Blinky blinky;
    private PinkeyInky pinkey,inky;
    private Clyde clyde;
    private boolean a,b,c,d;
    private boolean gameOver;

  

    public Game() {
        setPreferredSize(new Dimension(800, 660));
   
        setFocusable(true);
        addKeyListener(this);
        pacManGame = new PacManGame();
       
        pacMan = new PacMan(400, 300, 3);
        blinky = new Blinky(100,200,19,1);
        pinkey = new PinkeyInky(100, 300, 19, 1, Color.PINK);
        inky = new PinkeyInky(300, 500, 19, 1, Color.BLUE);
        clyde = new Clyde(500, 500, 19, 1);
        

     
        timer = new Timer(10, this);
        timer.start();

        level = 1;
        score = 0;
        life = 3;
        keyboard = new Keyboard();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Press any key to start a new game", getWidth()/2-100, getHeight()/2);
            return;
        }
        // draw  veggene
        for (java.awt.Rectangle wall : pacManGame.getWalls()) {
            g.setColor(Color.BLACK);
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }
    
        // draw  Pac-Man og monsters
        pacManGame.draw((Graphics2D) g,level);


        blinky.draw((Graphics2D) g);
        clyde.draw((Graphics2D) g);
        pinkey.draw((Graphics2D) g);
        inky.draw((Graphics2D) g);
        pacMan.draw((Graphics2D) g);
      
       
      
        
    
        // draw the level og score
        g.setColor(Color.GREEN);
        g.drawString("level: " + level, 20, 613);
        g.drawString("Score: " + score, 20, 633);
        g.drawString("Life: " + life, 20, 653);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacMan.update(keyboard, pacManGame.getWalls());

       
        blinky.update(pacMan.getX(), pacMan.getY(), pacManGame.getWalls());
        clyde.update(pacMan.getX(), pacMan.getY(), pacManGame.getWalls());
        inky.update(pacMan.getX(), pacMan.getY(), pacManGame.getWalls());
        pinkey.update(pacMan.getX(), pacMan.getY(), pacManGame.getWalls());
        a = pacMan.intersects(blinky.getBounds());
        b = pacMan.intersects(clyde.getBounds());
        c = pacMan.intersects(inky.getBounds());
        d = pacMan.intersects(pinkey.getBounds());

     
        if (((a|| b|| c || d) && life == 0)|| pacManGame.getDots().isEmpty()) {
            gameOver(getGraphics());
            gameOver = true;
            return;
        } else if (a|| b|| c || d) {
            life --;
            timer.stop();

            missedLive(getGraphics());
            pacMan.setX();
            pacMan.setY();

            timer.start();
            return;

          
        }
   
      
    
        
        for (Ellipse2D dot : pacManGame.getDots()) {
            if (pacMan.intersects(dot.getBounds2D())) {
                pacManGame.getDots().remove(dot);
                score += 10;
                break;
            }
        }
    
     
    
        // Check hvis alle dots ble spist opp.
        if (pacManGame.getDots().isEmpty()) {
            if (level < 3 ){
            level ++;
            repaint();
            }else {


            timer.stop();
            System.out.println("Success!");
            System.out.println("Final Score: " + score);
            System.exit(0);
            }
        }
    
        repaint();
    }
    

    private void gameOver(Graphics g) {
        pacManGame.drawGameOver((Graphics2D)g,level, score);
        timer.stop();
       
    }
    private void missedLive(Graphics g) {
       
        pacManGame.drawMissedLive((Graphics2D)g, life);
        timer.stop();
        
    
       
    }

  

    @Override
    public void keyReleased(KeyEvent e) {
        keyboard.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
public void keyPressed(KeyEvent e) {
    if (gameOver) {
        // reset the game state
        level = 1;
        score = 0;
        life = 3;
        pacMan = new PacMan(400, 300, 3);
        blinky = new Blinky(100,200,19,1);
        pinkey = new PinkeyInky(100, 300, 19, 1, Color.PINK);
        inky = new PinkeyInky(300, 500, 19, 1, Color.BLUE);
        clyde = new Clyde(500, 500, 19, 1);
        pacManGame = new PacManGame();
        keyboard = new Keyboard();
        gameOver = false;
        timer.start();
        repaint();
    } else {
        keyboard.keyPressed(e);
    }
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-Man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}