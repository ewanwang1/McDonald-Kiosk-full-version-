package test;

import main.menu.Food;
import main.menu.burger.beef.BigMac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFood {
    Food bigMac;

    @BeforeEach
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
