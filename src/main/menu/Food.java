package main.menu;

import main.exception.TooMuchFoodException;

import java.io.Serializable;
import java.util.Objects;

public abstract class Food implements Serializable {
    protected int price;
    protected String name;
    protected int amountOrdered;
    protected String type;
    protected int maxAmount = 100;

    //MODIFIES: this
    //EFFECT: Add the amount of customer order
    public void addOrderAmount(int order) throws TooMuchFoodException {
        if (order > 100) {
            throw new TooMuchFoodException("Sorry, we currently do not have this much "
                    + this.name + " in the inventory");
        }
        amountOrdered += order;
    }


    //Getters and Setters

    public int getAmountOrdered() {
        return amountOrdered;
    }

    //EFFECT: Return price of food
    public int getPrice() {
        return price;
    }

    //EFFECT: Set the price of the food
    public void setPrice(int newPrice) {
        price = newPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
