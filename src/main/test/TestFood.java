package test;

import menu.Food;
import menu.burger.beef.BigMac;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFood {
    Food bigMac;

    @Before
    public void setup() {
        bigMac = new BigMac();
        bigMac.addOrderAmount(3);
        bigMac.setPrice(21);
    }

    @Test
    public void testAddOrderAmount() {
        assertEquals(bigMac.getAmountOrdered(), 3);
    }

    @Test
    public void testSetPrice() {
        assertEquals(bigMac.getPrice(), 21);
    }

}
