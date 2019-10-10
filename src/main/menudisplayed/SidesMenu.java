package main.menudisplayed;

import main.menu.sides.ChickenNugget;
import main.menu.sides.Cookie;
import main.menu.sides.Fries;
import main.menu.sides.Sides;

import java.util.ArrayList;

public class SidesMenu extends Menu {
    public SidesMenu() {
        menu = new ArrayList<>();
        menu.add(0, null);
    }

    public void setup() {
        Sides cookie = new Cookie();
        Fries fries = new Fries();
        ChickenNugget chickenNugget = new ChickenNugget();
        this.addFood(cookie);
        this.addFood(fries);
        this.addFood(chickenNugget);
    }
}
