package ui.panels;

import main.menu.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderType extends Panels implements ActionListener {

    private JLabel label;
    private OrderFood orderBurger;
    private JButton orderDrinksBtn;
    private JButton orderSidesBtn;
    private JButton backbtn;

    public OrderType(JFrame javaFrame, Order currentOrder) {
        super(javaFrame, currentOrder);
        label = new JLabel("Order Type");
        JButton orderBurgerBtn = new JButton("Burger");
        backbtn = new JButton("Return to Main Menu");
        orderBurger = new OrderBurger(javaFrame, currentOrder);
        orderBurgerBtn.setActionCommand("Burger");
        orderBurgerBtn.addActionListener(this);
        backbtn.addActionListener(this);
        backbtn.setActionCommand("back");
        orderDrinksBtn = new JButton("Drinks");
        orderDrinksBtn.addActionListener(this);
        orderDrinksBtn.setActionCommand("Drinks");
        orderSidesBtn = new JButton("Sides");
        orderSidesBtn.addActionListener(this);
        orderSidesBtn.setActionCommand("Sides");

        add(label);
        add(bigBlankSpace);
        add(orderBurgerBtn);
        add(Box.createRigidArea(new Dimension(5, 10)));
        add(orderDrinksBtn);
        add(Box.createRigidArea(new Dimension(5, 10)));
        add(orderSidesBtn);
        add(Box.createRigidArea(new Dimension(5, 10)));
        add(backbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Burger":
                createOrderBurgerPanel();
                break;
            case "Drinks":
                createOrderDrinkPanel();
                break;
            case "Sides":
                createOrderSidesPanel();
                break;
            case "back":
                setVisible(false);
                javaFrame.add(new MainMenu(javaFrame, currentOrder));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    private void createOrderSidesPanel() {
        setVisible(false);
        javaFrame.add(new OrderSides(javaFrame, currentOrder));
    }

    private void createOrderDrinkPanel() {
        setVisible(false);
        javaFrame.add(new OrderDrinks(javaFrame, currentOrder));
    }

    private void createOrderBurgerPanel() {
        setVisible(false);
        javaFrame.add(orderBurger);
    }


}
