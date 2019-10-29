package main.menudisplayed;

import main.menu.Food;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public abstract class Menu {
    List<Food> menu;


    public Menu() {

    }

    //EFFECTS: add food to main.menu
    public void addFood(Food food) {
        menu.add(food);
    }

    //EFFECTS: Remove food from main.menu
    public void removeFood(Food food) {
        menu.remove(food);
    }

    public Boolean containFood(Food food) {
        return menu.contains(food);
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

    public List<Food> getMenu() {
        return menu;
    }
}
