import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.drink.Coke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.menu.Order;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoadSave {
    Food coke;
    ArrayList<Food> foodOrdered;
    Order order;

    @BeforeEach
    public void setUp() throws IOException, TooMuchFoodException {
        order = new Order();

        coke = new Coke();
        order.order(1, coke);
        order.save();
    }

    @Test
    // test list saves a food and brings the list back
    public void testBringListBack() throws ClassNotFoundException, IOException {
        order.load();
        Food f = order.getCurrentFoodOrdered().get(0);
        assertEquals(f.getName(), "Coke");
        order.save();
    }



}