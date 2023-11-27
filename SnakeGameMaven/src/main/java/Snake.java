import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<Point> snakeBody; // Armazena as posições do corpo da cobra
    private final int UNIT_SIZE; // Tamanho da unidade da grade do jogo
    private final int WIDTH; // Largura do campo do jogo
    private final int HEIGHT; // Altura do campo do jogo
    private Point food; // Posição da comida

    public Snake(int width, int height, int unitSize) {
        snakeBody = new ArrayList<>(); // Inicializa a lista do corpo da cobra
        snakeBody.add(new Point(width / 2, height / 2)); // Adiciona a cabeça da cobra no centro do campo
        UNIT_SIZE = unitSize; // Inicializa o tamanho da unidade
        WIDTH = width; // Inicializa a largura do campo
        HEIGHT = height; // Inicializa a altura do campo
        generateFood(); // Gera a posição inicial da comida
    }

    public ArrayList<Point> getSnakeBody() {
        return snakeBody; // Retorna o corpo da cobra
    }

    public void move(boolean isMovingRight, boolean isMovingLeft, boolean isMovingUp, boolean isMovingDown) {
        Point newHead = new Point(snakeBody.get(0)); // Cria uma nova cabeça para a cobra
        if (isMovingRight) {
            newHead.x += UNIT_SIZE; // Move para a direita (incrementa a coordenada x)
        }
        if (isMovingLeft) {
            newHead.x -= UNIT_SIZE; // Move para a esquerda (decrementa a coordenada x)
        }
        if (isMovingUp) {
            newHead.y -= UNIT_SIZE; // Move para cima (decrementa a coordenada y)
        }
        if (isMovingDown) {
            newHead.y += UNIT_SIZE; // Move para baixo (incrementa a coordenada y)
        }
        snakeBody.add(0, newHead); // Adiciona a nova cabeça à posição inicial da cobra

        // Verifica se a cobra comeu a comida, caso contrário, remove a última parte do corpo (rabo)
        if (!snakeBody.get(0).equals(food)) {
            snakeBody.remove(snakeBody.size() - 1);
        } else {
            generateFood(); // Gera uma nova posição para a comida
        }
    }

    public boolean checkCollision() {
        // Verifica colisão com as bordas do campo ou consigo mesma
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(0).equals(snakeBody.get(i))) {
                return true; // Retorna verdadeiro se houver colisão da cabeça com o corpo da cobra
            }
        }
        return snakeBody.get(0).x < 0 || snakeBody.get(0).x >= WIDTH || snakeBody.get(0).y < 0 || snakeBody.get(0).y >= HEIGHT;
        // Retorna verdadeiro se a cabeça da cobra atingir as bordas do campo
    }

    private void generateFood() {
        Random random = new Random(); // Cria um objeto Random para gerar números aleatórios
        // Gera uma nova posição aleatória para a comida dentro dos limites do campo
        int foodX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int foodY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        food = new Point(foodX, foodY); // Define a posição da comida usando um objeto Point
    }

    public Point getFood() {
        return food; // Retorna a posição da comida
    }
}
