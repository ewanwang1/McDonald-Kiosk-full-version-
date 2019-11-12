package main.statustracker;

import java.util.Observable;
import java.util.Observer;

public class KioskStatus implements Observer {
    int numItemsOrdered;

    public KioskStatus() {
        numItemsOrdered = 0;
    }

    @Override
    public void update(Observable o, Object arg) {
        numItemsOrdered += 1;
    }

    public int getItemsOrdered() {
        return numItemsOrdered;
    }
}
