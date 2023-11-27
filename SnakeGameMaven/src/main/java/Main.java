import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria uma instância do GameController para controlar a lógica do jogo
            GameController gameController = new GameController();

            // Cria uma instância do GameWindow para a interface gráfica do jogo
            GameWindow gameWindow = new GameWindow(gameController);

            // Cria um JFrame (janela) para conter o GameWindow
            JFrame frame = new JFrame("Snake Game"); // Define o título da janela como "Snake Game"
            frame.add(gameWindow); // Adiciona o painel do jogo à janela
            frame.pack(); // Redimensiona a janela para se adequar ao tamanho do GameWindow
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
            frame.setVisible(true); // Torna a janela visível

            // Inicia o jogo chamando o método startGame do GameController
            gameController.startGame();
        });
    }
}
