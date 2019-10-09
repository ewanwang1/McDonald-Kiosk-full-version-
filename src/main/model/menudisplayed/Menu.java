package main.model.menudisplayed;

import main.model.menu.Food;

import java.util.List;

public abstract class Menu {
    List<Food> menu;


    public Menu() {

    }

    //EFFECTS: add food to main.menu
    public void addFood(Food food) {
        menu.add(food);
    }


    //EFFECTS: prints out all food on the main.menu
    public void printMenu() {
        for (int i = 1; i < menu.size(); i++) {
            System.out.println(i + ": " + menu.get(i).getName());
        }
    }

    //EFFECT: Return food on main.menu that correspond to consumed foodIndex
    public Food getFood(int i) {
        for (Food f : menu) {
            if (menu.indexOf(f) == i) {
                return f;
            }
        }
        return null;

    }

    //EFFECT: return amount of items in the main.menu
    public int getSize() {
        return menu.size();
    }

    //EFFECT: set up the main.menu
    public abstract void setup();
}