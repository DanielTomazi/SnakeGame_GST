import org.junit.jupiter.api.Test;
import java.awt.Point;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    @Test
    public void testInitialSnakeState() {
        // Verifica o estado inicial da cobra
        int width = 600;
        int height = 600;
        int unitSize = 25;

        Snake snake = new Snake(width, height, unitSize);
        ArrayList<Point> snakeBody = snake.getSnakeBody();
        assertEquals(1, snakeBody.size()); // Verifica se a cobra começa com um segmento
        assertNotNull(snake.getFood()); // Verifica se a comida foi gerada
    }

    @Test
    public void testSnakeMovement() {
        // Verifica o movimento da cobra
        int width = 600;
        int height = 600;
        int unitSize = 25;

        Snake snake = new Snake(width, height, unitSize);

        // Move a cobra para a direita e verifica se a posição da cabeça foi alterada corretamente
        snake.move(true, false, false, false);
        ArrayList<Point> snakeBody = snake.getSnakeBody();
        Point head = snakeBody.get(0);
        assertEquals(new Point(width / 2 + unitSize, height / 2), head);

        // Move a cobra para cima e verifica se a posição da cabeça foi alterada corretamente
        snake.move(false, false, true, false);
        head = snakeBody.get(0);
        assertEquals(new Point(width / 2 + unitSize, height / 2 - unitSize), head);

        // Pode-se adicionar mais testes para outros movimentos e verificação de colisões
    }

    @Test
    public void testCollision() {
        // Verifica a detecção de colisão da cobra
        int width = 600;
        int height = 600;
        int unitSize = 25;

        Snake snake = new Snake(width, height, unitSize);

        // Verifica que a cobra não colide consigo mesma no início
        assertFalse(snake.checkCollision());

        // Faz a cobra colidir consigo mesma e verifica se a colisão é detectada corretamente
        ArrayList<Point> snakeBody = snake.getSnakeBody();
        Point initialHead = snakeBody.get(0);
        snakeBody.add(new Point(initialHead.x + unitSize, initialHead.y)); // Adiciona nova parte do corpo na frente da cabeça
        assertTrue(snake.checkCollision());
    }
}

