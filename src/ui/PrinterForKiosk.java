package ui;

import java.io.Serializable;

public class PrinterForKiosk implements Serializable {
    public PrinterForKiosk() {
    }

    void greet() {
        System.out.println("Welcome to Mcdonald. Please make your choice "
                + "by pressing the number that corresponds to your choice");
    }

    void displayInitialChoice() {
        System.out.println("What would you like to do? ");
        printInitialChoice();
    }

    //EFFECT: display main Menu
    void displayMainMenu() {
        System.out.println("Our option today is: ");
        System.out.println();
        System.out.println("1. Burger");
        System.out.println("2. Sides");
        System.out.println("3. Drink");
    }

    //EFFECT: print out all types of food Mcdonald has
    void printInitialChoice() {
        System.out.println("1. Order");
        System.out.println("2. View current order");
        System.out.println("3. Check out");
        System.out.println("4. Clear Order");
    }
}