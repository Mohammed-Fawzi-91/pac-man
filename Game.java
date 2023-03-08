import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener, KeyListener {
    private PacMan pacMan;
    private Monster[] monsters;
    private Timer timer;
    private int level;
    private int score;
    private Keyboard keyboard;
    private PacManGame pacManGame;
    PacManGame map = new PacManGame();

    public Game() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(map);
        setFocusable(true);
        addKeyListener(this);
        pacManGame = new PacManGame();

        pacMan = new PacMan(400, 300, 3);
        monsters = new Monster[3];
        for (int i = 0; i < 3; i++) {
            monsters[i] = new Monster(100 + i * 100, 100, 20);
        }
        timer = new Timer(10, this);
        timer.start();

        level = 1;
        score = 0;
        keyboard = new Keyboard();
    }

    private void setBackground(PacManGame map2) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        // draw the walls
        for (java.awt.Rectangle wall : pacManGame.getWalls()) {
            g.setColor(Color.BLACK);
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }
    
        // draw the Pac-Man character and monsters
        pacManGame.draw((Graphics2D) g);
        pacMan.draw((Graphics2D) g);
        for (Monster monster : monsters) {
            monster.draw((Graphics2D) g);
        }
    
        // draw the level and score
        g.setColor(Color.WHITE);
        g.drawString("Level: " + level, 20, 20);
        g.drawString("Score: " + score, 20, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacMan.update(keyboard, pacManGame.getWalls());
        for (Monster monster : monsters) {
            monster.update(pacMan.getX(), pacMan.getY(),pacManGame.getWalls());
            if (pacMan.intersects(monster.getBounds())) {
                gameOver();
                return;
            }
        }
        repaint();
    }

    private void gameOver() {
        timer.stop();
        System.out.println("Game Over!");
        System.out.println("Final Score: " + score);
        System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyboard.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboard.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
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