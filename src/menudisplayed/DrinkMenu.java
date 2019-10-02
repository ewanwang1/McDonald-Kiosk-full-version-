package menudisplayed;

import menu.drink.Coke;
import menu.drink.OrangeJuice;
import menu.drink.Sprite;

import java.util.ArrayList;

public class DrinkMenu extends Menu {
    public DrinkMenu() {
        menu = new ArrayList<>();
        menu.add(0, null);
    }

    public void setup() {
        Coke coke = new Coke();
        OrangeJuice orangeJuice = new OrangeJuice();
        Sprite sprite = new Sprite();
        this.addFood(coke);
        this.addFood(sprite);
        this.addFood(orangeJuice);
    }
}
