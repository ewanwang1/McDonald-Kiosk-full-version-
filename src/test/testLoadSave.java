import com.sun.org.apache.xpath.internal.operations.Or;
import menu.Food;
import menu.drink.Coke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testLoadSave {
    Food coke;
    ArrayList<Food> foodOrdered;
    Order order;

    @BeforeEach
    public void setUp() throws IOException {
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

    }

}