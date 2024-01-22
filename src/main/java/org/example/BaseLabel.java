package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseLabel extends JLabel {
    BaseLabel(String text,Color color){
        this.setText(text);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setForeground(color);
        this.setOpaque(false);
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
    }

}
