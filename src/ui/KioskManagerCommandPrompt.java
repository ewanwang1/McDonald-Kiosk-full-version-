package ui;

import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.Order;
import main.menudisplayed.BurgurMenu;
import main.menudisplayed.DrinkMenu;
import main.menudisplayed.Menu;
import main.menudisplayed.SidesMenu;
import main.statustracker.KioskStatus;

import java.io.IOException;
import java.util.*;


public class KioskManagerCommandPrompt extends Observable {

    private final PrinterForKioskCommandPrompt display = new PrinterForKioskCommandPrompt();
    private Scanner userInput;
    private Order currentOrder;
    private Menu currentMenuUsed;
    private BurgurMenu burgurMenu;
    private DrinkMenu drinkMenu;
    private SidesMenu sidesMenu;
    private Boolean orderComplete;
    private KioskStatus kioskStatus;


    public KioskManagerCommandPrompt() {
        userInput = new Scanner(System.in);
        currentOrder = new Order();
        orderComplete = false;
        kioskStatus = new KioskStatus();
        addObserver(kioskStatus);
    }

    public void startKiosk() throws IOException, ClassNotFoundException {
        display.greet();
        while (!orderComplete) {
//            currentOrder.load();
            display.displayInitialChoice();
            int typeChoice = userInput.nextInt();
            System.out.println();
            try {
                handleInitialChoice(typeChoice);
            } catch (UnkownCommandException e) {
                System.out.println(e.getMessage());
            }
//            currentOrder.save();
        }
        System.out.println("U have ordered " + kioskStatus.getItemsOrdered() + " item(s)");
        System.out.println();
        System.out.println("Thank you for visiting McDonald. Have a great day!!");
        userInput.close();

    }


    private void handleOrder() {
        int userChoiceOfFoodIndex = userInput.nextInt();
        System.out.println();
        Food userChoiceOfFood = currentMenuUsed.getFood(userChoiceOfFoodIndex);
        System.out.println("Awesome. Please enter the amount of " + userChoiceOfFood.getName() + " you would like");
        int userChoiceOfAmount = userInput.nextInt();
        try {
            makeOrder(userChoiceOfAmount, userChoiceOfFood, currentMenuUsed);
            System.out.println();
            System.out.println("Sweet, " + userChoiceOfAmount
                    + " " + userChoiceOfFood.getName()
                    + " has been added to the cart");
            System.out.println();
        } catch (TooMuchFoodException e) {
            System.out.println(e.getMessage());
        }

    }


    private void handleInitialChoice(int typeChoice) throws UnkownCommandException {
        switch (typeChoice) {
            case 1:
                startOrder();
                break;
            case 2:
                viewOrder();
                break;
            case 3:
                checkOut();
                break;
            case 4:
                currentOrder.clearOrder(currentMenuUsed);
                break;
            default:
                throw new UnkownCommandException("Sorry, I do not understand the command. Please try again");
        }
    }


    public void startOrder() {
        display.displayMainMenu();
        setChanged();
        notifyObservers();
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
        List<Food> menuItems = drinkMenu.getMenu();
        printMenu(menuItems);
        currentMenuUsed = drinkMenu;
        handleOrder();
    }

    private void handleSideMenu() {
        System.out.println("Our options today for sides are:");
        List<Food> menuItems = sidesMenu.getMenu();
        printMenu(menuItems);
        currentMenuUsed = sidesMenu;
        handleOrder();
    }

    private void handleBurgerMenu() {
        System.out.println("Our options today for burger are:");
        List<Food> menuItems = burgurMenu.getMenu();
        printMenu(menuItems);
        currentMenuUsed = burgurMenu;
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
            HashMap<Food, Integer> currentOrderItems = currentOrder.getCurrentFoodOrdered();
            printCurrentOrderItems();
            System.out.println();
        }
    }

    //EFFECT: prints out order
    public void printCurrentOrderItems() {
        for (HashMap.Entry<Food, Integer> entry : currentOrder.getCurrentFoodOrdered().entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey().getName());
        }
    }

    //REQUIRE: order not empty
    //MODFIES: this, order
    //EFFECT: Check out the items that the customer have ordered, and clear the order
    private void checkOut() {
        System.out.println("The total for your order is $" + currentOrder.totalCostCalc());
        currentOrder.clearOrder(currentMenuUsed);
        orderComplete = true;
    }

    //MODIFIES: Order
    //EFFECT: Make the order for the customer
    public void makeOrder(int userChoiceOfAmount, Food userChoiceOfFood, Menu currentMenuUsed)
            throws TooMuchFoodException {
        currentOrder.order(userChoiceOfAmount, userChoiceOfFood);
    }


    //EFFECT: set up the menu so user can place order off of it
    public void setUpMenu() {
        burgurMenu = new BurgurMenu();
        sidesMenu = new SidesMenu();
        drinkMenu = new DrinkMenu();

        burgurMenu.setup();
        sidesMenu.setup();
        drinkMenu.setup();
    }


    //EFFECTS: prints out all food on the main.menu
    private void printMenu(List<Food> menuItems) {
        for (int i = 1; i < menuItems.size(); i++) {
            System.out.println(i + ": " + menuItems.get(i).getName());
        }
    }


    // Display things onto kiosk
    private void greet() {
        display.greet();
    }

    private void displayInitialChoice() {
        display.displayInitialChoice();
    }

    //EFFECT: display main Menu
    private void displayMainMenu() {
        display.displayMainMenu();
    }


    //EFFECT: print out all types of food Mcdonald has
    private void printInitialChoice() {
        display.printInitialChoice();
    }


}


