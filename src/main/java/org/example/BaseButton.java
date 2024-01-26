package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseButton extends JButton implements ActionListener {
    private final BaseLabel associatedLabel1;
    private final BaseLabel associatedLabel2;
    private final BaseLabel associatedLabel3;
    private final FormattedTextField textField;
    private final String labelname;
    private final CardLayout layout;
    private final BasePanel panel;

    public BaseButton(String iconPath,BaseLabel label1 ,BaseLabel label2,BaseLabel outputLabel,FormattedTextField inputTextField,String outputLabelName,CardLayout layout,BasePanel panel) {
        ImageIcon imageIcon = new ImageIcon(iconPath);

        this.setSize(50, 50);
        this.setLayout(new GridLayout());
        this.textField = inputTextField;
        this.associatedLabel1 = label1;
        this.associatedLabel2 = label2;
        this.associatedLabel3 = outputLabel;
        this.labelname = outputLabelName;
        this.layout = layout;
        this.panel = panel;
        this.addActionListener(this);

        // Set the icon and make the button transparent
        this.setIcon(new ImageIcon(getScaledImage(imageIcon.getImage(), 50, 50)));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.setFocusable(false);
        //this.setOpaque(false);
        this.setVisible(true);
    }

    private Image getScaledImage(Image srcImg, int width, int height) {
        // Scale the image to fit the button size
        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            String currentText1 = associatedLabel1.getText();

            if("CELSIUS".equals(currentText1)){
                associatedLabel1.setText("FAHRENHEIT");
            }
            if("FAHRENHEIT".equals(currentText1)){
                associatedLabel1.setText("KELVIN");
            }
            if("KELVIN".equals(currentText1)){
                associatedLabel1.setText("CELSIUS");
            }
            DocumentUpdate.handleDocumentUpdate(textField,associatedLabel1,associatedLabel2,associatedLabel3,labelname,layout,panel);
        }
    }
}
