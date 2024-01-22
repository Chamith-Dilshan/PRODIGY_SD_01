package org.example;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {
    BasePanel(Color color, java.awt.LayoutManager layout) {
        this.setBackground(color);
        this.setLayout(layout);
    }
}
