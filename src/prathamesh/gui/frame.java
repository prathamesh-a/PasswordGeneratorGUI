package prathamesh.gui;

import javax.swing.*;
import java.awt.*;

public class frame extends JFrame{

    private JTextField field;
    private JButton genButton;
    private JButton copyButton;
    private checkBox checkBox;
    private JTextField output;
    public boolean isGenerated;
    public JLabel success;

    public frame(){
        setTextFields();
        create();
        setLabels();
        this.checkBox = new checkBox(this);
        button();
    }

    private void create(){
        this.getContentPane().setLayout(null);
        this.setTitle("Password Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/icon.png"));
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
    }

    private void setLabels(){
        label("Password Generator", Color.CYAN, 20,80, 5, 350, 50);
        label("Password Length:", new Color(0xBDBCAC), 18,20, 70, 180, 30);
        label("Include symbols?", new Color(0xBDBCAC), 18,20, 120, 180, 30);
        label("Include Numbers?", new Color(0xBDBCAC), 18, 20, 170, 180, 30);
        label("Include Uppercase?", new Color(0xBDBCAC), 18, 20, 220, 220, 30);
        label("Include Lowercase?", new Color(0xBDBCAC), 18, 20, 270, 220, 30);
        successText();
    }

    private JLabel label(String text, Color color, int size, int x, int y, int width, int height){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
        this.add(label);
        return label;
    }

    private void setTextFields(){
        textField(240, 75, 100, 25);
        output(75, 340, 240, 50);
    }

    private void textField(int x, int y, int width, int height){
        field = new JTextField();
        field.setBounds(x, y, width, height);
        field.setBackground(Color.lightGray);
        field.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        this.add(field);
    }

    public String getLength(){
        return field.getText();
    }

    private void button(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/genButton.png"));
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 150, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        this.genButton = new JButton(icon);
        this.genButton.setBounds(20, 400, 150, 120);
        this.genButton.setBorder(BorderFactory.createEmptyBorder());
        this.genButton.setContentAreaFilled(false);
        this.genButton.setBackground(Color.DARK_GRAY);
        this.genButton.addActionListener(new listener(checkBox, this));
        this.add(genButton);


        ImageIcon icon2 = new ImageIcon(getClass().getResource("/img/copy.png"));
        Image img2 = icon2.getImage() ;
        Image newimg2 = img2.getScaledInstance( 150, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon2 = new ImageIcon( newimg2 );
        this.copyButton = new JButton(icon2);
        this.copyButton.setBounds(220, 400, 150, 120);
        this.copyButton.setBorder(BorderFactory.createEmptyBorder());
        this.copyButton.setContentAreaFilled(false);
        this.copyButton.setBackground(Color.DARK_GRAY);
        this.copyButton.addActionListener(new listener(checkBox, this));
        this.add(copyButton);
    }

    private void output(int x, int y, int width, int height){
        output = new JTextField();
        output.setBounds(x, y, width, height);
        output.setBackground(Color.lightGray);
        output.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        this.add(output);
    }

    private void successText(){
        success = label("Copied!", Color.green, 20, 150, 510, 100, 30);
        success.setVisible(false);
    }
    public void setSuccessText(){
        success.setVisible(false);
    }

    public JButton getGenButton() {
        return genButton;
    }

    public JButton getCopyButton(){return copyButton;}
    public JTextField getOutput(){return output;}
}
