package main.menu;


import main.exception.Loadable;
import main.exception.Savable;
import main.exception.TooMuchFoodException;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


public class Order implements Iterable<Food>, Serializable, Loadable, Savable {
    private LinkedList<Food> currentFoodOrdered;
    private Food food;

    public Order() {
        currentFoodOrdered = new LinkedList<>();
    }


    //EFFECT: add given food to curentOrder and update AmountOrdered
    public void order(int amount, Food food) throws TooMuchFoodException {
        food.addOrderAmount(amount);
        currentFoodOrdered.add(food);
    }


    //EFFECT: return amount of items that the customer have ordered so far
    public int getSize() {
        return currentFoodOrdered.size();
    }

    public LinkedList<Food> getCurrentFoodOrdered() {
        return currentFoodOrdered;
    }


    @Override
    public Iterator<Food> iterator() {
        return currentFoodOrdered.iterator();
    }

    public void clearOrder() {
        for (int i = currentFoodOrdered.size(); i > 0; i--) {
            currentFoodOrdered.remove(i - 1);
        }
        System.out.println("Order has been cleared");
    }

    public boolean isOrderEmpty() {
        return currentFoodOrdered.isEmpty();
    }

    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("t.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(currentFoodOrdered);
        oos.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("t.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // food = (Food) ois.readObject();
        currentFoodOrdered = (LinkedList<Food>) ois.readObject();
        ois.close();
    }

    // taken from https://stackoverflow.com/questions/16111496/
    // java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the


}

