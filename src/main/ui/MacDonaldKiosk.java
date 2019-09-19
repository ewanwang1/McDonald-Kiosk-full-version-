package ui;

import menu.burger.beef.BigMac;
import menu.drink.Coke;
import menudisplayed.Menu;

public class MacDonaldKiosk {
    public static void main(String[] args) {

        KioskManager kioskManager = new KioskManager();
        kioskManager.setUpMenu();
        kioskManager.startOrder();
    }


    public static void setUpMenu(Menu menu) {
        Coke coke = new Coke();
        BigMac bigMac = new BigMac();
        menu.addFood(coke);
        menu.addFood(bigMac);
    }

}
