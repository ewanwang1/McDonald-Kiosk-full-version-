package main.ui;

import java.io.IOException;
import java.io.Serializable;

public class MacDonaldKiosk implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        KioskManager kioskManager = new KioskManager();
        kioskManager.setUpMenu();
        kioskManager.startKiosk();

    }





}
