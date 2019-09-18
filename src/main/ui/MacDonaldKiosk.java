package ui;

import menu.burger.Beef.BigMac;
import menu.drink.Coke;
import menu.menuDisplayed.Menu;

public class MacDonaldKiosk {
    public static void main(String[] args) {

        KioskManager kioskManager = new KioskManager();
        kioskManager.setUpMenu();
        kioskManager.startOrder();
    }



    public static void setUpMenu(Menu menu){
        Coke coke = new Coke();
        BigMac bigMac = new BigMac();
        menu.addFood(coke);
        menu.addFood(bigMac);
    }

//    public static void setUpOrder(Order order){
//        Coke coke = new Coke();
//        BigMac bigMac = new BigMac();
//        order.order(1, 1);
//        order.order(33, 2);
//    }
}
