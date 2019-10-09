package main.model.menudisplayed;

import main.model.menu.burger.beef.BigMac;
import main.model.menu.burger.beef.CheeseBurger;
import main.model.menu.burger.beef.Hamburger;
import main.model.menu.burger.beef.MightyAngus;
import main.model.menu.burger.chicken.SpicyGrilledChickenBurger;
import main.model.menu.burger.chicken.TomatoGrilledChickenBurger;

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
