package ui;

import menu.Food;
import menudisplayed.BurgurMenu;
import menudisplayed.DrinkMenu;
import menudisplayed.Menu;
import menudisplayed.SidesMenu;

import java.util.Scanner;

public class KioskManager {
    private Scanner userInput;
    private Order currentOrder;
    private Menu menu;
    private BurgurMenu burgurMenu;
    private DrinkMenu drinkMenu;
    private SidesMenu sidesMenu;
    private Boolean orderComplete;
    private int menuSize;


    public KioskManager() {
        userInput = new Scanner(System.in);
        currentOrder = new Order();
        orderComplete = false;
    }

    public void startOrder() {
        greet();
        while (!orderComplete) {
            displayMainMenu();
            int typeChoice = userInput.nextInt();
            System.out.println();
            handleTypes(typeChoice);
        }
        System.out.println("Thank you for visiting McDonald. Have a great day!!");
        userInput.close();

    }

    private void greet() {
        System.out.println("Welcome to Mcdonald. Please make your order "
                + "by pressing the number that corresponds to your choice");
    }

    private void handleOrder() {
        int userChoiceOfFoodIndex = userInput.nextInt();
        System.out.println();
        Food userChoiceOfFood = menu.getFood(userChoiceOfFoodIndex);
        System.out.println("Awesome. Please enter the amount of " + userChoiceOfFood.getName() + " you would like");
        int userChoiceOfAmount = userInput.nextInt();
        makeOrder(userChoiceOfAmount, userChoiceOfFood);
        System.out.println();
        System.out.println("Sweet, " + userChoiceOfAmount
                + " " + userChoiceOfFood.getName()
                + " has been added to the cart");
        System.out.println();
    }


    //EFFECT: display the first round of options for the customer
    private void displayMainMenu() {
        System.out.println("Our option today is: ");
        printTypes();
    }


    //EFFECT: print out all types of food Mcdonald has
    private void printTypes() {
        System.out.println("1. Burgers");
        System.out.println("2. Sides");
        System.out.println("3. Drinks");
        System.out.println("4. View current order");
        System.out.println("5. Check Out");
        System.out.println("6. Quit");
    }

    private void handleTypes(int typeChoice) {
        switch (typeChoice) {
            case 1:
                handleBurgerMenu();
                break;
            case 2:
                handleSideMenu();
                break;
            case 3:
                handleDrinkMenu();
                break;
            case 4:
                viewOrder();
                break;
            case 5:
                checkOut();
                break;
            default:
        }
    }

    private void handleDrinkMenu() {
        System.out.println("Our options today for drinks are:");
        drinkMenu.printMenu();
        menu = drinkMenu;
        handleOrder();
    }

    private void handleSideMenu() {
        System.out.println("Our options today for sides are:");
        sidesMenu.printMenu();
        menu = sidesMenu;
        handleOrder();
    }

    private void handleBurgerMenu() {
        System.out.println("Our options today for burger are:");
        burgurMenu.printMenu();
        menu = burgurMenu;
        handleOrder();
    }

    private void quit() {
        orderComplete = true;
    }

    //EFFECT: view list of items that the customer have ordered so far
    public void viewOrder() {
        if (currentOrder.getSize() == 0) {
            System.out.println("Nothing has been ordered yet");
            System.out.println();

        } else {
            System.out.println("You have currently ordered:");
            currentOrder.printCurrentOrder();
            System.out.println();
        }
    }

    //Check out the items that the customer have ordered
    private void checkOut() {
        System.out.println("The total for your order is $" + totalCostCalc());
        orderComplete = true;
    }

    //EFFECT: return the total cost of customer's order
    private int totalCostCalc() {
        int total = 0;
        for (Food f : currentOrder) {
            total += (f.getPrice() * f.getAmountOrdered());
        }
        return total;
    }

    //EFFECT: Make the order for the customer
    public void makeOrder(int userChoiceOfAmount, Food userChoicOfFood) {
        currentOrder.order(userChoiceOfAmount, userChoicOfFood);
    }


    public void setUpMenu() {
        burgurMenu = new BurgurMenu();
        sidesMenu = new SidesMenu();
        drinkMenu = new DrinkMenu();

        burgurMenu.setup();
        sidesMenu.setup();
        drinkMenu.setup();
    }


}
