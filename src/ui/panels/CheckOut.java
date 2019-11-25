package ui.panels;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOut extends Panels {
    JLabel checkOutMsg;


    public CheckOut(JFrame javaFrame) {
        super(javaFrame);
        label = new JLabel("Check out");
        checkOutMsg = new JLabel("The total for your order is");

        add(label);
        add(bigBlankSpace);
        add(checkOutMsg);

    }


}
