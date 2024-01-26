package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseButton extends JButton implements ActionListener {
    private final BaseLabel associatedLabel;

    public BaseButton(String iconPath,BaseLabel label ) {
        ImageIcon imageIcon = new ImageIcon(iconPath);

        this.setSize(50, 50);
        this.setLayout(new GridLayout());
        this.associatedLabel = label;
        this.addActionListener(this);

        // Set the icon and make the button transparent
        this.setIcon(new ImageIcon(getScaledImage(imageIcon.getImage(), 50, 50)));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.setFocusable(false);
        this.setOpaque(false);
        this.setVisible(true);
    }

    private Image getScaledImage(Image srcImg, int width, int height) {
        // Scale the image to fit the button size
        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            String currentText1 = associatedLabel.getText();

            if("CELSIUS".equals(currentText1)){
                associatedLabel.setText("FAHRENHEIT");
            }
            if("FAHRENHEIT".equals(currentText1)){
                associatedLabel.setText("CELSIUS");
            }

        }
    }
}
