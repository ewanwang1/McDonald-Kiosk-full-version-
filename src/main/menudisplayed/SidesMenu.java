package menudisplayed;

import menu.sides.ChickenNugget;
import menu.sides.Cookie;
import menu.sides.Fries;
import menu.sides.Sides;

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
