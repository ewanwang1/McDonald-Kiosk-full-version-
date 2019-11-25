package ui.panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderType extends Panels implements ActionListener {
    private JLabel label;
    private JTextField field;

    public OrderType(JFrame javaFrame) {
        super(javaFrame);
        label = new JLabel("Order Type");
        JButton btn = new JButton("Burger");
        btn.setActionCommand("Burger");
        btn.addActionListener(this);
        add(label);
        add(bigBlankSpace);
        add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
