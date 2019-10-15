import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.Order;
import main.menu.burger.beef.BigMac;
import main.menu.drink.Coke;
import main.menu.drink.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrder {
    Order testOrder;
    BigMac bigMac;
    Drink coke;
    LinkedList<Food> currentFoodOrdered;

    @BeforeEach
    public void setup() {
        testOrder = new Order();
        bigMac = new BigMac();
        coke = new Coke();
        currentFoodOrdered = new LinkedList<>();
        currentFoodOrdered.add(bigMac);
        currentFoodOrdered.add(coke);
    }

    @Test
    public void testOrder() throws TooMuchFoodException {
        testOrder.order(1, bigMac);
        testOrder.order(2, coke);
        assertEquals(testOrder.getSize(), 2);
        assertEquals(testOrder.iterator().next(), bigMac);
        assertEquals(testOrder.iterator().next().getAmountOrdered(), 1);
        assertEquals(testOrder.getCurrentFoodOrdered(), currentFoodOrdered);
        testOrder.clearOrder();
        assertTrue(testOrder.isOrderEmpty());
        testOrder.getCurrentFoodOrdered();

    }


}
