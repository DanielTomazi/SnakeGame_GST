import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameWindow extends JPanel {
    private GameController gameController; // Instância do controlador do jogo

    public GameWindow(GameController controller) {
        this.gameController = controller; // Recebe o controlador do jogo
        setPreferredSize(new Dimension(600, 600)); // Define o tamanho preferencial da janela do jogo
        setBackground(Color.BLACK); // Define a cor de fundo da janela do jogo como preto
        setFocusable(true); // Permite que a janela do jogo tenha foco para capturar eventos de teclado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Captura as teclas pressionadas para alterar a direção da cobra no jogo
                int key = e.getKeyCode();
                if ((key == KeyEvent.VK_LEFT) && (!gameController.isMovingRight())) {
                    gameController.setMovingDirection(false, true, false, false);
                } else if ((key == KeyEvent.VK_RIGHT) && (!gameController.isMovingLeft())) {
                    gameController.setMovingDirection(true, false, false, false);
                } else if ((key == KeyEvent.VK_UP) && (!gameController.isMovingDown())) {
                    gameController.setMovingDirection(false, false, true, false);
                } else if ((key == KeyEvent.VK_DOWN) && (!gameController.isMovingUp())) {
                    gameController.setMovingDirection(false, false, false, true);
                }
            }
        });

        // Inicia um loop em uma nova Thread para atualizar o painel do jogo
        new Thread(() -> {
            while (true) {
                repaint(); // Atualiza o painel do jogo (chamando o método paintComponent)
                try {
                    Thread.sleep(100); // Pausa para controlar a velocidade da cobra
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Point> snakeBody = gameController.getSnakeBody(); // Obtém o corpo da cobra
        Point food = gameController.getFood(); // Obtém a posição do alimento
        int unitSize = gameController.getUnitSize(); // Obtém o tamanho da unidade do jogo

        // Desenha a cobra
        g.setColor(Color.GREEN);
        for (Point bodyPart : snakeBody) {
            g.fillRect(bodyPart.x, bodyPart.y, unitSize, unitSize); // Desenha cada parte do corpo da cobra
        }

        // Desenha o alimento
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, unitSize, unitSize); // Desenha o alimento na posição determinada

        // Verifica se o jogo acabou e exibe a mensagem "Game Over"
        if (gameController.isGameOver()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 40));
            g.drawString("Game Over", 200, 300);
        }
    }
}
