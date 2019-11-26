package ui.panels;

import main.menu.Food;
import main.menu.Order;
import main.menu.burger.Burger;
import main.menudisplayed.BurgurMenu;
import main.menudisplayed.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderBurger extends OrderFood implements ActionListener {

    public OrderBurger(JFrame javaFrame, Order order) {
        super(javaFrame, order);

//        label = new JLabel("What would you like to order?");
//        add(label);
//
//        for (int i = 1; i < burgurMenu.getSize(); i++) {
//            buttonName = "order " + burgurMenu.getFood(i).getName();
//            JButton btn = new JButton(buttonName);
//            add(Box.createRigidArea(new Dimension(5, 10)));

//            btn.addActionListener(this);
//            btn.setActionCommand(Integer.toString(i));
//            add(Box.createRigidArea(new Dimension(5, 10)));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        setVisible(false);
        Food userChoiceOfFood = burgurMenu.getFood(Integer.parseInt(action));
        javaFrame.add(new OrderAmount(javaFrame, currentOrder, userChoiceOfFood));
    }

    @Override
    public Menu getMenu() {
        return burgurMenu;
    }

    @Override
    public OrderFood getFoodOrder() {
        return this;
    }
}
