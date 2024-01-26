package org.example;

import javax.swing.*;
import java.awt.*;

public class BaseMessageBox {
    public void ShowErrorMessage() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/Error.png");

        ImageIcon scaledIcon = getScaledImage(icon, 50, 50);
        JOptionPane.showMessageDialog(null, "That is Not a Number!", "Error", JOptionPane.ERROR_MESSAGE, scaledIcon);
    }

    private ImageIcon getScaledImage(ImageIcon originalIcon, int width, int height) {

        // Get the original image from the ImageIcon
        Image srcImg = originalIcon.getImage();

        // Scale the image to fit the specified size
        Image scaledImg = srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        return new ImageIcon(scaledImg);
    }
}
