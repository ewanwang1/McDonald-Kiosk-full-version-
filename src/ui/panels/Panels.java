package ui.panels;

import main.menu.Order;
import main.menudisplayed.BurgurMenu;
import main.menudisplayed.DrinkMenu;
import main.menudisplayed.SidesMenu;

import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel {
    protected Order currentOrder;
    protected BurgurMenu burgurMenu;
    protected SidesMenu sidesMenu;
    protected DrinkMenu drinkMenu;
    protected JLabel label;
    protected JFrame javaFrame;
    protected  Component blankSpace = Box.createRigidArea(new Dimension(5, 10));
    protected final Component bigBlankSpace = Box.createRigidArea(new Dimension(5, 70));

    public Panels(JFrame javaFrame, Order order) {
        this.javaFrame = javaFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setUpMenu();
        this.currentOrder = order;
    }

    private void setUpMenu() {
        burgurMenu = new BurgurMenu();
        sidesMenu = new SidesMenu();
        drinkMenu = new DrinkMenu();
        burgurMenu.setup();
        sidesMenu.setup();
        drinkMenu.setup();
    }


}


