package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormattedTextField extends JFormattedTextField {

    public FormattedTextField(Color backgroundColor, Color textColor) {
        this.setText("0");
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
        this.setPreferredSize(new Dimension(150, 30));
        this.setHorizontalAlignment(JFormattedTextField.CENTER);
        this.setBorder(null);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);
        this.setColumns(10);
    }
}