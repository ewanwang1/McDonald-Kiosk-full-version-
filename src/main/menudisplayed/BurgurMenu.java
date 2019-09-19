package menudisplayed;

import menu.burger.beef.BigMac;
import menu.burger.beef.CheeseBurger;
import menu.burger.beef.Hamburger;
import menu.burger.beef.MightyAngus;
import menu.burger.chicken.SpicyGrilledChickenBurger;
import menu.burger.chicken.TomatoGrilledChickenBurger;

import java.util.ArrayList;

public class BurgurMenu extends Menu {
    public BurgurMenu() {
        menu = new ArrayList<>();
        menu.add(0, null);
    }

    public void setup() {
        //Burger
        BigMac bigMac = new BigMac();
        CheeseBurger cheeseBurger = new CheeseBurger();
        Hamburger hamburger = new Hamburger();
        MightyAngus mightyAngus = new MightyAngus();
        this.addFood(bigMac);
        this.addFood(cheeseBurger);
        this.addFood(hamburger);
        this.addFood(mightyAngus);

        //Chicken
        SpicyGrilledChickenBurger spicyGrilledChickenBurger = new SpicyGrilledChickenBurger();
        TomatoGrilledChickenBurger tomatoGrilledChickenBurger = new TomatoGrilledChickenBurger();
        this.addFood(spicyGrilledChickenBurger);
        this.addFood(tomatoGrilledChickenBurger);
    }
}
