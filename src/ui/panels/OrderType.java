package ui.panels;

import main.menu.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderType extends Panels implements ActionListener {

    private JLabel label;
    private OrderBurger orderBurger;
    private JButton backbtn;

    public OrderType(JFrame javaFrame, Order currentOrder) {
        super(javaFrame, currentOrder);
        label = new JLabel("Order Type");
        JButton orderBurgerBtn = new JButton("Burger");
        backbtn = new JButton("Go back");
        orderBurger = new OrderBurger(javaFrame, currentOrder);
        orderBurgerBtn.setActionCommand("Burger");
        orderBurgerBtn.addActionListener(this);
        backbtn.addActionListener(this);
        backbtn.setActionCommand("back");

        add(label);
        add(bigBlankSpace);
        add(orderBurgerBtn);
        add(blankSpace);
        add(backbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Burger":
                setVisible(false);
                javaFrame.add(orderBurger);
                break;
            case "back":
                setVisible(false);
                javaFrame.add(new MainMenu(javaFrame, currentOrder));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }


}
