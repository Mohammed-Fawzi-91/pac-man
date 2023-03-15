/**

Keyboard klassen implementerer KeyListener for å lytte på tastetrykk og lagre en HashMap for å holde styr på statusen til hver tast.
*/



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Keyboard implements KeyListener {
    private Map<Integer, Boolean> keyMap;

    public Keyboard() {
        keyMap = new HashMap<>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyMap.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean isKeyPressed(int keyCode) {
        return keyMap.getOrDefault(keyCode, false);
    }
}
