package ui.panels;

import main.menu.Order;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Panels implements ActionListener {
    private OrderType orderType;
    private CheckOut checkOut;
    private ViewOrder viewOrder;


    public MainMenu(JFrame javaFrame, Order currentOrder) {
        super(javaFrame, currentOrder);
        orderType = new OrderType(javaFrame, currentOrder);
        checkOut = new CheckOut(javaFrame, currentOrder);
        viewOrder = new ViewOrder(javaFrame, currentOrder);
        label = new JLabel("Main Menu");


        JButton orderBtn = new JButton("Oder");
        orderBtn.setActionCommand("order");
        orderBtn.addActionListener(this);

        JButton checkOutBtn = new JButton("Check Out");
        checkOutBtn.setActionCommand("checkOut");
        checkOutBtn.addActionListener(this);


        JButton viewOrderBtn = new JButton("View current order");
        viewOrderBtn.addActionListener(this);
        viewOrderBtn.setActionCommand("viewOrder");

        add(label);
        add(bigBlankSpace);
        add(orderBtn);
        add(blankSpace);
        add(Box.createRigidArea(new Dimension(5, 10)));
        add(checkOutBtn);
        add(blankSpace);
        add(viewOrderBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        String action = e.getActionCommand();
        switch (action) {
            case "order":
                javaFrame.add(orderType);
                break;
            case "checkOut":
                javaFrame.add(checkOut);
                break;
            case "viewOrder":
                javaFrame.add(viewOrder);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}


