package ui.panels;

import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel {
    protected JLabel label;
    protected JFrame javaFrame;
    protected  final Component blankSpace = Box.createRigidArea(new Dimension(5,20));
    protected  final Component bigBlankSpace = Box.createRigidArea(new Dimension(5,70));

    public Panels(JFrame javaFrame) {
        this.javaFrame = javaFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

}
