package menu.menuDisplayed;

import menu.Food;

import java.util.List;

public class Menu {
    List<Food> menu;


    public Menu() {

    }

    //EFFECTS: add food to menu
    public void addFood(Food food) {
        menu.add(food);
        }


    //EFFECTS: prints out all food on the menu
    public void printMenu() {
        for (int i = 1; i < menu.size(); i++) {
            System.out.println(i + ": " + menu.get(i).getName());
        }
    }

    //EFFECT: Return food on menu that correspond to consumed foodIndex
    public Food getFood(int i) {
        for (Food f : menu) {
            if (menu.indexOf(f) == i) {
                return f;
            }
        }
        return null;

        //Todo : add an exception to handle foodNotFound
    }

    //EFFECT: return amount of items in the menu
    public int getSize() {
        return menu.size();
    }
}
