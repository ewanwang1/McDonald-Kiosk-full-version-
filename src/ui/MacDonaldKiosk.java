package ui;


import java.io.IOException;
import java.io.Serializable;

public class MacDonaldKiosk implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runCommandPrompt();
    }


    private static void runCommandPrompt() throws IOException, ClassNotFoundException {
        KioskManagerCommandPrompt kioskManager = new KioskManagerCommandPrompt();
        kioskManager.setUpMenu();
        kioskManager.startKiosk();
    }
}