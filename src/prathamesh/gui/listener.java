package prathamesh.gui;

import prathamesh.generator.generator;
import prathamesh.generator.input;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class listener implements ActionListener {

    private checkBox checkBox;
    private frame frame;
    private input input;

    public listener(checkBox checkBox, frame frame){
        this.checkBox = checkBox;
        this.frame = frame;
        this.input = new input();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getGenButton()){
            if (frame.getLength().equalsIgnoreCase("")){
                frame.getOutput().setText("Enter a value.");
                return;
            }
            try {
                input.length = Integer.parseInt(frame.getLength());
            }
            catch (NumberFormatException exception){frame.getOutput().setText("Enter a numeric value.");return;}

            if (input.length==0){
                frame.getOutput().setText("Length cannot be 0!");
                return;
            }
            input.includeSymbols = checkBox.getSymbol().isSelected();
            input.includeNumbers = checkBox.getNumber().isSelected();
            input.includeLowercase = checkBox.getLowerCase().isSelected();
            input.includeUppercase = checkBox.getUpperCase().isSelected();
            check();

        }
        if (e.getSource() == frame.getCopyButton()){
            if (frame.isGenerated){
                StringSelection selection = new StringSelection(frame.getOutput().getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);

                frame.success.setVisible(true);
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.schedule(frame::setSuccessText, 1, TimeUnit.SECONDS);
            }
        }
    }

    private void check(){
        if (!(input.includeSymbols || input.includeNumbers || input.includeLowercase || input.includeUppercase)){
            frame.getOutput().setText("Select at least one option!");
        }
        else {
            frame.getOutput().setText(new generator(input).getPassword());
            frame.isGenerated = true;
        }
    }
}
