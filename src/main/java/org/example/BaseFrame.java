package org.example;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    BaseFrame(){
        this.setSize(500,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Convertor");
        this.setLayout(new GridLayout(2,1));

        ImageIcon image = new ImageIcon("src/main/resources/images/logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.WHITE);

        this.setVisible(true);
    }
}
