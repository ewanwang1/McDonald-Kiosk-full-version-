package ui.panels;

import main.menu.Order;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOut extends Panels {
    JLabel checkOutMsg;


    public CheckOut(JFrame javaFrame, Order currentOrder) {
        super(javaFrame, currentOrder);
        label = new JLabel("Check out");
        checkOutMsg = new JLabel("The total for your order is");

        add(label);
        add(bigBlankSpace);
        add(checkOutMsg);

    }


}
