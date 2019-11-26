package ui.panels;

import main.exception.TooMuchFoodException;
import main.menu.Food;
import main.menu.Order;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class OrderAmount extends Panels implements ActionListener {
    Integer amount;
    Food food;
    JTextField javaTextField;
    JButton btn;
    private final String failMsg1 = "Sorry, we do not have that much inventory right now. \n";
    private final String failMsg2 = " Please enter a lesser amount to order";

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
            createOrderSuccessPopUp();
            javaFrame.add(new MainMenu(javaFrame, currentOrder));

        } catch (TooMuchFoodException ex) {
            createOrderFailPopUp();
        }
    }

    //EFFECT: open a new java frame that confirms you have successfully placed ur order
    private void createOrderSuccessPopUp() {
        JFrame orderSucess = new JFrame();
        orderSucess.add(new JLabel("order successfully placed!!"));
        orderSucess.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        orderSucess.setPreferredSize(new Dimension(200, 100));
        orderSucess.setLayout(new FlowLayout());
        orderSucess.setResizable(false);
        orderSucess.setVisible(true);
        orderSucess.pack();
        orderSucess.setLocationRelativeTo(null);
    }

    private void createOrderFailPopUp() {
        JFrame orderFail = new JFrame();
        orderFail.add(new JLabel("<html>" + failMsg1 + ".<br/>" + failMsg2 + ".</html>"));
        orderFail.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        orderFail.setPreferredSize(new Dimension(350, 100));
        orderFail.setLayout(new FlowLayout());
        orderFail.setResizable(false);
        orderFail.setVisible(true);
        orderFail.pack();
        orderFail.setLocationRelativeTo(null);
    }
}
