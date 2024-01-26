package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class BaseTextField extends JTextField implements DocumentListener {
    private BaseTextField  textField;
    private final BaseLabel associatedLabel;
    BaseTextField(Color backgroundColor,Color textColor,BaseLabel label){
        this.associatedLabel = label;
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,70));
        this.setPreferredSize(new Dimension(150, 30));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(null);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);
        this.setText("0");
        this.getDocument().addDocumentListener(this);
    }
    public void setOtherTextField(BaseTextField otherTextField) {
        this.textField = otherTextField;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        updateConversion();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateConversion();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateConversion();
    }

    private void updateConversion() {
        String input = this.getText();
        if (!input.isEmpty()) {
            try {
                double inputValue = Double.parseDouble(input);
                String newText = "";

                if ("CELSIUS".equals(associatedLabel.getText())) {
                    double result = ConverterLogic.celsiusToFahrenheit(inputValue);
                    newText = String.format("%.2f°F", result);
                } else if ("FAHRENHEIT".equals(associatedLabel.getText())) {
                    double result = ConverterLogic.fahrenheitToCelsius(inputValue);
                    newText = String.format("%.2f°C", result);
                }

                // Update only if the new text is different
                if (!newText.equals(textField.getText())) {
                    textField.setText(newText);
                }
            } catch (NumberFormatException ex) {
                // Handle the case where the input is not a valid number
            }
        } else {
            // Clear the other text field if the input is empty
            textField.setText("");
        }
    }

}
