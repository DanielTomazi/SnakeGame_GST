import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.util.ArrayList;

public class GameController implements ActionListener {
    private Snake snake; // Instância da classe Snake para controlar a cobra
    private final int WIDTH = 600; // Largura da área do jogo
    private final int HEIGHT = 600; // Altura da área do jogo
    private final int UNIT_SIZE = 25; // Tamanho de cada unidade (bloco) do jogo
    private Timer timer; // Timer para controlar o tempo do jogo
    // Variáveis para controlar a direção da cobra
    private boolean isMovingRight = true;
    private boolean isMovingLeft = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isGameOver = false; // Indica se o jogo terminou

    public GameController() {
        snake = new Snake(WIDTH, HEIGHT, UNIT_SIZE); // Inicializa a cobra com as dimensões e tamanho da unidade
        timer = new Timer(100, this); // Inicializa o Timer com um intervalo de 100 milissegundos, e utiliza 'this' como o ActionListener
        isGameOver = false; // Inicializa o estado do jogo como não terminado
    }

    public void startGame() {
        timer.start(); // Inicia o jogo, começa a contagem do Timer
    }

    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            // Movimenta a cobra com base nas direções atuais
            snake.move(isMovingRight, isMovingLeft, isMovingUp, isMovingDown);
            // Verifica colisões da cobra consigo mesma ou com as bordas do jogo
            if (snake.checkCollision()) {
                gameOver(); // Chama a função de fim de jogo caso ocorra uma colisão
            }
        }
    }

    private void gameOver() {
        isGameOver = true; // Define o estado do jogo como terminado
        timer.stop(); // Para o Timer do jogo
        // Mostra um diálogo perguntando se o jogador quer reiniciar o jogo
        int choice = JOptionPane.showConfirmDialog(null, "Game Over! Do you want to restart?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            restartGame(); // Reinicia o jogo se o jogador escolher sim
        } else {
            System.exit(0); // Sai do jogo se o jogador escolher não
        }
    }

    private void restartGame() {
        snake = new Snake(WIDTH, HEIGHT, UNIT_SIZE); // Reinicia a cobra com posições e tamanho iniciais
        isGameOver = false; // Define o estado do jogo como não terminado novamente
        // Define as direções da cobra como inicial (movendo para a direita)
        isMovingRight = true;
        isMovingLeft = false;
        isMovingUp = false;
        isMovingDown = false;
        timer.start(); // Reinicia o Timer para continuar o jogo
    }

    // Getters e setters para várias informações do jogo

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public void setMovingDirection(boolean right, boolean left, boolean up, boolean down) {
        // Define a direção de movimento da cobra com base nos parâmetros
        isMovingRight = right;
        isMovingLeft = left;
        isMovingUp = up;
        isMovingDown = down;
    }

    public ArrayList<Point> getSnakeBody() {
        return snake.getSnakeBody(); // Retorna o corpo da cobra
    }

    public Point getFood() {
        return snake.getFood(); // Retorna a posição da comida
    }

    public int getUnitSize() {
        return UNIT_SIZE; // Retorna o tamanho da unidade do jogo
    }

    public boolean isGameOver() {
        return isGameOver; // Retorna se o jogo acabou
    }
}
