package main.model.menudisplayed;

import main.model.menu.sides.ChickenNugget;
import main.model.menu.sides.Cookie;
import main.model.menu.sides.Fries;
import main.model.menu.sides.Sides;

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
