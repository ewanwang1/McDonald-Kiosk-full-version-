package test;

import menu.drink.Coke;
import menu.drink.Drink;
import menu.sides.Cookie;
import menu.sides.Sides;
import menudisplayed.BurgurMenu;
import menudisplayed.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMenu {
    Menu testMenu;
    Drink coke;
    Sides cookie;

    @BeforeEach
    public void setup() {
        testMenu = new BurgurMenu();
        coke = new Coke();
        cookie = new Cookie();
        testMenu.addFood(coke);
        testMenu.addFood(cookie);
    }

    @Test
    public void testAddFood() {
        assertEquals(testMenu.getSize(), 3);
    }

    @Test
    public void testGetFood() {
        assertEquals(testMenu.getFood(1), coke);
    }

}
