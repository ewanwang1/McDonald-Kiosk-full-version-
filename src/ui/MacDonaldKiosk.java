package ui;

import menu.burger.beef.BigMac;
import menu.drink.Coke;
import menudisplayed.Menu;

import java.io.IOException;
import java.io.Serializable;

public class MacDonaldKiosk implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        KioskManager kioskManager = new KioskManager();
        kioskManager.setUpMenu();

        kioskManager.startKiosk();

    }


    public static void setUpMenu(Menu menu) {
        Coke coke = new Coke();
        BigMac bigMac = new BigMac();
        menu.addFood(coke);
        menu.addFood(bigMac);
    }

}
