import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.Order;
import main.menu.burger.beef.BigMac;
import main.menu.drink.Coke;
import main.menu.drink.Drink;
import main.menudisplayed.Menu;
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
    Menu testMenu;

    @BeforeEach
    public void setup() {
        testOrder = new Order();
        bigMac = new BigMac();
        coke = new Coke();
        currentFoodOrdered = new LinkedList<>();
        currentFoodOrdered.add(bigMac);
        currentFoodOrdered.add(coke);
        testMenu.addFood(bigMac);
        testMenu.addFood(coke);
    }

    @Test
    public void testOrder() throws TooMuchFoodException {
        testOrder.order(1, bigMac, testMenu );
        testOrder.order(2, coke, testMenu);
        assertEquals(testOrder.getSize(), 2);
        assertEquals(testOrder.getCurrentFoodOrdered().get(bigMac), bigMac);
        assertEquals(testOrder.getCurrentFoodOrdered().get(coke), 1);
        assertEquals(testOrder.getCurrentFoodOrdered(), currentFoodOrdered);
        testOrder.clearOrder(testMenu);
        assertTrue(testOrder.isOrderEmpty());
        testOrder.getCurrentFoodOrdered();
        testOrder.clearOrder(testMenu);
        assertTrue(testOrder.isOrderEmpty());
        assertEquals(testOrder.getSize(),0);
        testOrder.totalCostCalc();
        testOrder.order(1, bigMac, testMenu);
        testOrder.removeFood(bigMac);
        testOrder.getCurrentFoodOrdered();
    }


}
