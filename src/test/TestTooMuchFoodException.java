import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.burger.Burger;
import main.menu.drink.Coke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestTooMuchFoodException {
    private Food testCoke;

    @BeforeEach
    public void setup(){
        testCoke = new Coke();
    }

    @Test
    public void testNoFoodException(){
        try {
            testCoke.addOrderAmount(2);
        } catch (TooMuchFoodException e) {
            e.getMessage();
            fail("U have enough food");
        }
    }

    @Test
    public void testTooMuchFoodException(){
        try {
            testCoke.addOrderAmount(101); fail("You don't have enough food in inventory!!");
        } catch (TooMuchFoodException e) {
            e.getMessage();
        }
    }
}
