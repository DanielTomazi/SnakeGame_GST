import java.awt.*;
import java.util.Random;

public class Food {
    private Point food; // Variável que armazena a posição da comida
    private final int UNIT_SIZE; // Tamanho do bloco da grade do jogo

    // Construtor da classe Food
    public Food(int width, int height, int unitSize) {
        UNIT_SIZE = unitSize; // Inicializa o tamanho do bloco
        generateFood(width, height); // Gera a posição inicial da comida
    }

    // Método para obter a posição da comida
    public Point getFoodPosition() {
        return food;
    }

    // Método para gerar a comida em uma posição aleatória
    public void generateFood(int width, int height) {
        Random random = new Random(); // Cria um objeto Random para gerar números aleatórios
        // Calcula a posição aleatória da comida dentro dos limites do jogo
        int foodX = random.nextInt(width / UNIT_SIZE) * UNIT_SIZE;
        int foodY = random.nextInt(height / UNIT_SIZE) * UNIT_SIZE;
        food = new Point(foodX, foodY); // Define a posição da comida usando um objeto Point
    }
}
