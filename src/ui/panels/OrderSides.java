package ui.panels;

import main.menu.Food;
import main.menu.Order;
import main.menudisplayed.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSides extends OrderFood implements ActionListener {
    public OrderSides(JFrame javaFrame, Order order) {
        super(javaFrame, order);
    }

    @Override
    public Menu getMenu() {
        return sidesMenu;
    }

    @Override
    public OrderFood getFoodOrder() {
        return this;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        setVisible(false);
        Food userChoiceOfFood = sidesMenu.getFood(Integer.parseInt(action));
        javaFrame.add(new OrderAmount(javaFrame, currentOrder, userChoiceOfFood));
    }
}
