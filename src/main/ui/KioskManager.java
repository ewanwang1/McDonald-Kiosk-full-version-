package main.ui;

import main.menu.Food;
import main.menudisplayed.BurgurMenu;
import main.menudisplayed.DrinkMenu;
import main.menudisplayed.Menu;
import main.menudisplayed.SidesMenu;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class KioskManager implements Serializable {
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

    public void startKiosk() throws IOException, ClassNotFoundException {
        greet();
        while (!orderComplete) {
            currentOrder.load();
            displayInitialChoice();
            int typeChoice = userInput.nextInt();
            System.out.println();
            handleInitialChoice(typeChoice);
            currentOrder.save();
        }

        System.out.println("Thank you for visiting McDonald. Have a great day!!");
        userInput.close();

    }

    private void greet() {
        System.out.println("Welcome to Mcdonald. Please make your choice "
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


    private void displayInitialChoice() {
        System.out.println("What would you like to do? ");
        printInitialChoice();
    }

    //EFFECT: display main Menu
    private void displayMainMenu() {
        System.out.println("Our option today is: ");
        System.out.println();
        System.out.println("1. Burger");
        System.out.println("2. Sides");
        System.out.println("3. Check out");
        System.out.println("4. Quit");
    }


    //EFFECT: print out all types of food Mcdonald has
    private void printInitialChoice() {
        System.out.println("1. Order");
        System.out.println("2. View current order");
        System.out.println("3. Clear Order");
        System.out.println("4. Check out");
        System.out.println("5. Quit");
    }


    private void handleInitialChoice(int typeChoice) {
        switch (typeChoice) {
            case 1:
                startOrder();
                break;
            case 2:
                viewOrder();
                break;
            case 3:
                currentOrder.clearOrder();
                break;
            case 4:
                checkOut();
                break;
            case 5:
                quit();
                break;
            default:
        }
    }

    private void startOrder() {
        displayMainMenu();
        int userChoiceOfType = userInput.nextInt();
        switch (userChoiceOfType) {
            case 1:
                handleBurgerMenu();
                return;
            case 2:
                handleSideMenu();
                break;
            case 3:
                handleDrinkMenu();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + userChoiceOfType);
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
        currentOrder.clearOrder();
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
