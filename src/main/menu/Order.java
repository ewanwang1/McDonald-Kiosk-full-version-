package main.menu;


import main.exception.TooMuchFoodException;
import main.menudisplayed.Menu;

import java.io.*;
import java.util.HashMap;


public class Order implements Serializable {
    private HashMap<Food, Integer> currentFoodOrdered;
    private Food food;

    public Order() {
        currentFoodOrdered = new HashMap<>();
    }


    //EFFECT: add given food to curentOrder and update AmountOrdered
    public void order(int amount, Food food, Menu menu) throws TooMuchFoodException {
        food.addOrderAmount(amount);
        currentFoodOrdered.put(food, amount);
        if (menu.containFood(food)) {
            menu.removeFood(food);
        }

    }

    public void removeFood(Food food) {
        currentFoodOrdered.remove(food);
    }

    //EFFECT: return amount of items that the customer have ordered so far
    public int getSize() {
        return currentFoodOrdered.size();
    }

    public HashMap<Food, Integer> getCurrentFoodOrdered() {
        return currentFoodOrdered;
    }


    public void clearOrder(Menu menu) {

        for (Food food : currentFoodOrdered.keySet()) {
            if (!menu.containFood(food)) {
                menu.addFood(food);
            }
        }
        currentFoodOrdered.clear();

        System.out.println("Order has been cleared");

    }


    public boolean isOrderEmpty() {
        return currentFoodOrdered.isEmpty();
    }


    public int totalCostCalc() {
        int total = 0;
        for (Food f : currentFoodOrdered.keySet()) {
            total += (f.getPrice() * f.getAmountOrdered());
        }
        return total;
    }


    //EFFECT: print out all items that the customer have ordered so far
//    public void printCurrentOrderItems() {
//        for (HashMap.Entry<Food, Integer> entry : currentFoodOrdered2.entrySet()) {
//            System.out.println(entry.getValue() + " " + entry.getKey().getName());
//        }
//    }

//    public void save() throws IOException {
//        FileOutputStream fos = new FileOutputStream("t.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(currentFoodOrdered);
//        oos.close();
//    }
//
//    public void load() throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream("t.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        // food = (Food) ois.readObject();
//        currentFoodOrdered = (LinkedList<Food>) ois.readObject();
//        ois.close();
//    }

    // taken from https://stackoverflow.com/questions/16111496/
    // java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the


}

