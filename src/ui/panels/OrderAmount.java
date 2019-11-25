package ui.panels;

import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.Order;
import main.menudisplayed.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderAmount extends Panels implements ActionListener {
    Integer amount;
    Food food;
    JTextField javaTextField;
    JButton btn;


    public OrderAmount(JFrame javaFrame, Order currentOrder, Food food) {
        super(javaFrame, currentOrder);
        this.food = food;
        label = new JLabel("How many " + food.getName() + " would you like?");
        javaTextField = new JTextField();
        btn = new JButton("Submit");
        btn.addActionListener(this);

        add(label);
        add(blankSpace);
        add(javaTextField);
        add(blankSpace);
        add(btn);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            amount = Integer.parseInt(javaTextField.getText());
            currentOrder.order(amount, food);
            setVisible(false);
            javaFrame.add(new OrderType(javaFrame, currentOrder));

        } catch (TooMuchFoodException ex) {
            ex.printStackTrace();
        }
    }
}
