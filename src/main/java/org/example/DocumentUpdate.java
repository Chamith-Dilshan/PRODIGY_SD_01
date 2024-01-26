package org.example;

import java.awt.*;

public class DocumentUpdate {
    public static void handleDocumentUpdate(FormattedTextField textField, BaseLabel label1, BaseLabel label2, BaseLabel outputLabel, String outputLabelName, CardLayout cardLayout, BasePanel panel) {
        String userInputText = textField.getText();

        // Check if userInputText is empty or null
        if (userInputText == null || userInputText.isEmpty()) {
            // Handle case where userInputText is empty or null
            handleEmptyOrNullInput(textField, outputLabel, outputLabelName, cardLayout, panel);
        } else {
            try {
                // Attempt to parse userInputText as a Double
                Double userInput = Double.valueOf(userInputText);
                // Successfully parsed, perform conversion and update UI
                handleValidNumberInput(userInput, label1, label2, outputLabel, outputLabelName, cardLayout, panel);
            } catch (NumberFormatException ex) {
                // Not a valid number, handle accordingly
                handleInvalidNumberInput(textField, outputLabel, outputLabelName, cardLayout, panel);
            }
        }
    }

    private static void handleEmptyOrNullInput(FormattedTextField textField, BaseLabel outputLabel, String outputLabelName, CardLayout cardLayout, BasePanel panel) {
        // Show a warning message for empty or null input
        BaseMessageBox messageBox = new BaseMessageBox();
        messageBox.ShowErrorMessage();

        // Request focus on the appropriate field
        panel.requestFocusInWindow();
    }

    private static void handleValidNumberInput(Double userInput, BaseLabel label1, BaseLabel label2, BaseLabel outputLabel, String outputLabelName, CardLayout cardLayout, BasePanel panel) {
        double output = ConverterLogic.performConversion(label1.getText(), label2.getText(), userInput);
        cardLayout.show(panel, outputLabelName);
        outputLabel.setText(String.valueOf(output));
    }

    private static void handleInvalidNumberInput(FormattedTextField textField, BaseLabel outputLabel, String outputLabelName, CardLayout cardLayout, BasePanel panel) {
        // Show a warning message for invalid number input
        BaseMessageBox messageBox = new BaseMessageBox();
        messageBox.ShowErrorMessage();

        // Request focus on the appropriate field
        panel.requestFocusInWindow();
    }
}
