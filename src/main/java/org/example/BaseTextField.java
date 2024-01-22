package org.example;

import javax.swing.*;
import java.awt.*;

public class BaseTextField extends JTextField {
    BaseTextField(Color backgroundColor,Color textColor){
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,70));
        this.setPreferredSize(new Dimension(150, 30));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(null);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);
    }
}
