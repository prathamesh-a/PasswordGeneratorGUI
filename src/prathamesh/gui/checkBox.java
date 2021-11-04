package prathamesh.gui;

import javax.swing.*;
import java.awt.*;

public class checkBox {
    private JCheckBox symbol;
    private JCheckBox number;
    private JCheckBox upperCase;
    private JCheckBox lowerCase;
    private final JFrame frame;

    public checkBox(JFrame frame){
        this.frame = frame;
        create();
    }

    private void create(){
        symbol = new JCheckBox();
        number = new JCheckBox();
        upperCase = new JCheckBox();
        lowerCase = new JCheckBox();

        properties(symbol, 235, 128);
        properties(number, 235, 178);
        properties(upperCase, 235, 228);
        properties(lowerCase, 235, 278);
    }

    private void properties(JCheckBox box, int x, int y){
        box.setBounds(x, y, 17, 17);
        box.setBackground(Color.DARK_GRAY);
        frame.add(box);
    }

    public JCheckBox getSymbol() {
        return symbol;
    }

    public JCheckBox getNumber() {
        return number;
    }

    public JCheckBox getUpperCase() {
        return upperCase;
    }

    public JCheckBox getLowerCase() {
        return lowerCase;
    }
}
