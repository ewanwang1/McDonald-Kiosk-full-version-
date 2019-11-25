package ui.panels;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Panels implements ActionListener {
    private OrderType orderType;
    private CheckOut checkOut;


    public MainMenu(JFrame javaFrame) {
        super(javaFrame);
        orderType = new OrderType(javaFrame);
        checkOut = new CheckOut(javaFrame);
        label = new JLabel("Main Menu");


        JButton orderBtn = new JButton("Oder");
        orderBtn.setActionCommand("order");
        orderBtn.addActionListener(this);

        JButton checkOutBtn = new JButton("Check Out");
        checkOutBtn.setActionCommand("checkOut");
        checkOutBtn.addActionListener(this);

        add(label);
        add(bigBlankSpace);
        add(orderBtn);
        add(blankSpace);
        add(checkOutBtn);
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
//            case 3:  monthString = "March";
//                break;

            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}


