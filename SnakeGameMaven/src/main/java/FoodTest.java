import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void testGenerateFood() {
        // Simulação das dimensões do jogo
        int width = 400;
        int height = 300;
        int unitSize = 10;

        // Criando uma instância de Food
        Food food = new Food(width, height, unitSize);

        // Verificando se a comida está dentro dos limites do jogo
        Point foodPosition = food.getFoodPosition();
        assertTrue(foodPosition.getX() >= 0 && foodPosition.getX() < width);
        assertTrue(foodPosition.getY() >= 0 && foodPosition.getY() < height);
        assertEquals(0, (int) foodPosition.getX() % unitSize);
        assertEquals(0, (int) foodPosition.getY() % unitSize);
    }

    @Test
    public void testGetFoodPosition() {
        // Simulação das dimensões do jogo
        int width = 400;
        int height = 300;
        int unitSize = 10;

        // Criando uma instância de Food
        Food food = new Food(width, height, unitSize);

        // Obtendo a posição da comida e verificando se é do tipo Point
        Point foodPosition = food.getFoodPosition();
        assertNotNull(foodPosition);
        assertTrue(foodPosition instanceof Point);
    }
}

