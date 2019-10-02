package ui;


import exception.Loadable;
import exception.Savable;
import menu.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Order implements Iterable<Food>, Serializable, Loadable, Savable {
    private ArrayList<Food> currentFoodOrdered;
    private Food food;

    public Order() {
        currentFoodOrdered = new ArrayList<>();
    }


    //EFFECT: add given food to curentOrder and update AmountOrdered
    public void order(int amount, Food food) {
        currentFoodOrdered.add(food);
        food.addOrderAmount(amount);
    }


    //EFFECT: print out all items that the customer have ordered so far
    public void printCurrentOrder() {
        for (Food f : currentFoodOrdered) {
            System.out.println(f.getAmountOrdered() + " " + f.getName());
        }

    }


    //EFFECT: return amount of items that the customer have ordered so far
    public int getSize() {
        return currentFoodOrdered.size();
    }

    public ArrayList<Food> getCurrentFoodOrdered() {
        return currentFoodOrdered;
    }


    @Override
    public Iterator<Food> iterator() {
        return currentFoodOrdered.iterator();
    }

    public void clearOrder() {
        for (int i = 0; i < (currentFoodOrdered.size() + 2); i++) {
            currentFoodOrdered.remove(i);
        }
    }

    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\data\\UBC\\2nd year\\Cpsc 210\\Personal project\\t.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(currentFoodOrdered);
        oos.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\data\\UBC\\2nd year\\Cpsc 210\\Personal project\\t.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // food = (Food) ois.readObject();
        currentFoodOrdered = (ArrayList<Food>) ois.readObject();
        ois.close();
    }

    // taken from https://stackoverflow.com/questions/16111496/
    // java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the

    public void testLoadable(Loadable loadable) throws IOException, ClassNotFoundException {
        loadable.load();
    }


}

