package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseLabel extends JLabel {
    BaseLabel(String text){
        this.setText(text);
        this.setSize(100,100);
        this.setBackground(Color.GRAY);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(false);
        this.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
    }

}
