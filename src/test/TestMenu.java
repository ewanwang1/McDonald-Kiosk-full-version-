
import main.menu.drink.Coke;
import main.menu.drink.Drink;
import main.menu.sides.Cookie;
import main.menu.sides.Sides;
import main.menudisplayed.BurgurMenu;
import main.menudisplayed.DrinkMenu;
import main.menudisplayed.Menu;
import main.menudisplayed.SidesMenu;
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
        testSidesMenu.getMenu();

    }

    @Test
    public void testPrint(){

    }



}
