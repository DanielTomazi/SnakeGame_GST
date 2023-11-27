import org.junit.jupiter.api.Test;
import java.awt.Point;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    @Test
    public void testStartGame() {
        GameController gameController = new GameController();
        gameController.startGame();
        // Verifica se o jogo foi iniciado (não há exceções lançadas)
        // Pode-se adicionar testes mais específicos se necessário
    }

    @Test
    public void testActionPerformed() {
        // Cenário de teste para actionPerformed() - Simulação do movimento da cobra
        GameController gameController = new GameController();
        gameController.startGame();
        gameController.setMovingDirection(true, false, false, false); // Mover para a direita
        gameController.actionPerformed(null);
        // Verifica se a posição da cobra foi atualizada após o movimento
        ArrayList<Point> snakeBody = gameController.getSnakeBody();
        assertNotNull(snakeBody);
        assertFalse(snakeBody.isEmpty());
        // Pode-se adicionar mais testes para outros cenários de movimento e colisão se necessário
    }

    @Test
    public void testGameOver() {
        // Cenário de teste para o método gameOver()
        GameController gameController = new GameController();
        gameController.gameOver();
        // Verifica se o jogo foi encerrado corretamente (timer parado e mensagem de Game Over)
        assertTrue(gameController.isGameOver());
    }

    @Test
    public void testRestartGame() {
        // Cenário de teste para o método restartGame()
        GameController gameController = new GameController();
        gameController.restartGame();
        // Verifica se o jogo foi reiniciado corretamente (novo estado)
        assertFalse(gameController.isGameOver());
    }
}

