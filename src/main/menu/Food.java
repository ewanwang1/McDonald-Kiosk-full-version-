package menu;

public abstract class Food {
    protected int price;
    protected String name;
    protected int amountOrdered;
    protected String type;

    //EFFECT: Add the amount of customer order
    public void AddOrderAmount(int order){
        amountOrdered += order;
    }


    //Getters and Setters

    public int getAmountOrdered() {
        return amountOrdered;
    }

    //EFFECT: Return price of food
    public  int getPrice(){
        return price;
    }

    //EFFECT: Set the price of the food
    public void setPrice(int newPrice){
        price = newPrice;
    }

    public String getName() {
        return name;
    }

    //EFFECT: return food type
    public String getType(){
        return type;
    }


}
