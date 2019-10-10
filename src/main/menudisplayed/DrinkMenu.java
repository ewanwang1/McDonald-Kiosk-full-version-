package main.menudisplayed;

import main.menu.drink.Coke;
import main.menu.drink.OrangeJuice;
import main.menu.drink.Sprite;

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
