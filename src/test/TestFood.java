
import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.burger.beef.BigMac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFood {
    Food bigMac;


    @BeforeEach
    public void setup() {
        bigMac = new BigMac();
    }

    @Test
    public void testAddOrderAmount() throws TooMuchFoodException {
        bigMac.addOrderAmount(3);
        assertEquals(bigMac.getAmountOrdered(), 3);
    }

    @Test
    public void testGetAmountOrdered() throws TooMuchFoodException {
        assertEquals(bigMac.getAmountOrdered(), 0);
        bigMac.addOrderAmount(3);
        assertEquals(bigMac.getAmountOrdered(), 3);
        bigMac.addOrderAmount(5);
        assertEquals(bigMac.getAmountOrdered(),8);
    }

    @Test
    public void testSetPrice() throws TooMuchFoodException {
        bigMac.addOrderAmount(21);
        bigMac.setPrice(21);
        assertEquals(bigMac.getPrice(), 21);
        assertEquals(bigMac.getName(), "BigMac");

    }

    @Test
    public void testAllFood() {
        try {
            bigMac.addOrderAmount(101);
            fail("Exception should have been thrown");
        } catch (TooMuchFoodException e) {

        }
    }
}
