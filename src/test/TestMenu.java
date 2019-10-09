package test;

import main.model.menu.drink.Coke;
import main.model.menu.drink.Drink;
import main.model.menu.sides.Cookie;
import main.model.menu.sides.Sides;
import main.model.menudisplayed.BurgurMenu;
import main.model.menudisplayed.DrinkMenu;
import main.model.menudisplayed.Menu;
import main.model.menudisplayed.SidesMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMenu {
    Menu testBurgerMenu;
    Menu testSidesMenu;
    Menu testDrinkMenu;
    Drink coke;
    Sides cookie;

    @BeforeEach
    public void setup() {
        testBurgerMenu = new BurgurMenu();
        testSidesMenu = new SidesMenu();
        testDrinkMenu = new DrinkMenu();
        coke = new Coke();
        cookie = new Cookie();
        testBurgerMenu.addFood(coke);
        testBurgerMenu.addFood(cookie);
    }

    @Test
    public void testAddFood() {
        testSidesMenu.getSize();
        assertEquals(testBurgerMenu.getSize(), 3);
        testSidesMenu.printMenu();
    }

    @Test
    public void testGetFood() {
        assertEquals(testBurgerMenu.getFood(1), coke);
        assertEquals(testBurgerMenu.getFood(13), null);
    }

    @Test
    public void testSetUp(){
        testBurgerMenu.setup();
        testDrinkMenu.setup();
        testSidesMenu.setup();

    }

    @Test
    public void testPrint(){

    }



}
