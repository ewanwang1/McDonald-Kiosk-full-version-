package ui;

import menu.Food;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order implements Iterable<Food> {
    private List<Food> currentFoodOrdered;

    public Order() {
        currentFoodOrdered = new ArrayList<>();
    }


    //EFFECT: add given food to curentOrder and update AmountOrdered
    public void order(int amount, Food food) {
        currentFoodOrdered.add(food);
        food.AddOrderAmount(amount);
    }


    //EFFECT: print out all items that the customer have ordered so far
    public void printCurrentOrder() {
        for (Food f : currentFoodOrdered)
            System.out.println(f.getAmountOrdered() + " " + f.getName());
    }


    //EFFECT: return amount of items that the customer have ordered so far
    public int getSize(){
        return currentFoodOrdered.size();
    }


    @Override
    public Iterator<Food> iterator() {
        return currentFoodOrdered.iterator();
    }
}

