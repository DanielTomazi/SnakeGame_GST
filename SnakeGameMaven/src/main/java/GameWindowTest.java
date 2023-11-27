import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

public class GameWindowTest {

    @Test
    public void testKeyPressed() {
        GameController gameController = new GameController();
        GameWindow gameWindow = new GameWindow(gameController);

        // Simulando pressionamento de teclas e verificando se as direções são definidas corretamente
        KeyEvent leftKey = new KeyEvent(gameWindow, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'A');
        KeyEvent rightKey = new KeyEvent(gameWindow, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'D');
        KeyEvent upKey = new KeyEvent(gameWindow, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'W');
        KeyEvent downKey = new KeyEvent(gameWindow, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'S');

        gameWindow.getKeyListeners()[0].keyPressed(leftKey);
        assertFalse(gameController.isMovingRight());
        assertTrue(gameController.isMovingLeft());

        gameWindow.getKeyListeners()[0].keyPressed(rightKey);
        assertTrue(gameController.isMovingRight());
        assertFalse(gameController.isMovingLeft());

        gameWindow.getKeyListeners()[0].keyPressed(upKey);
        assertTrue(gameController.isMovingUp());
        assertFalse(gameController.isMovingDown());

        gameWindow.getKeyListeners()[0].keyPressed(downKey);
        assertTrue(gameController.isMovingDown());
        assertFalse(gameController.isMovingUp());
    }
}

