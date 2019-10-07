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
    }

    @Test
    public void testAddOrderAmount() {
        bigMac.addOrderAmount(3);
        assertEquals(bigMac.getAmountOrdered(), 3);
    }

    @Test
    public void testGetAmountOrdered() {
        bigMac.addOrderAmount(3);
        assertEquals(bigMac.getAmountOrdered(), 3);
    }

    @Test
    public void testSetPrice() {
        bigMac.addOrderAmount(3);
        bigMac.setPrice(21);
        assertEquals(bigMac.getPrice(), 21);
        assertEquals(bigMac.getName(), "BigMac");
    }

    @Test
    public void testAllFood(){

    }
}