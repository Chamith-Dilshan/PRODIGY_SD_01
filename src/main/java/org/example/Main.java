package org.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {

        BaseFrame frame = new BaseFrame();

        BasePanel panelA = new BasePanel(Color.WHITE,new GridLayout(2,1));
        BasePanel panelB = new BasePanel(Color.WHITE,new GridLayout(2,1));
        BasePanel panel1 = new BasePanel(new Color(255, 82, 82),new GridLayout(1,3));
        BasePanel panel2 = new BasePanel(new Color(255, 82, 82),new CardLayout());
        BasePanel panel3 = new BasePanel(Color.WHITE,new CardLayout());
        BasePanel panel4 = new BasePanel(Color.WHITE,new GridLayout(1,3));

        BaseLabel label1 = new BaseLabel("CELSIUS", Color.white,20);
        BaseLabel label2 = new BaseLabel("FAHRENHEIT", new Color(255, 82, 82),20);
        BaseLabel label3 = new BaseLabel("OUTput", Color.black,70);
        BaseLabel label4 = new BaseLabel("OUTput", Color.black,70);

        FormattedTextField formattedTextField1 = new FormattedTextField(new Color(255, 82, 82),Color.WHITE);
        FormattedTextField formattedTextField2 = new FormattedTextField(Color.WHITE,new Color(255, 82, 82));

        CardLayout cardLayout1 = (CardLayout) panel2.getLayout();
        CardLayout cardLayout2 = (CardLayout) panel3.getLayout();

        BaseButton buttonLeft1 = new BaseButton("src/main/resources/images/leftArrow.png", label1,label2,label4,formattedTextField1,"label4",cardLayout2,panel3);
        BaseButton buttonRight1 = new BaseButton("src/main/resources/images/rightArrow.png", label1,label2,label4,formattedTextField1,"label4",cardLayout2,panel3);

        BaseButton buttonLeft2 = new BaseButton("src/main/resources/images/leftArrow.png", label2,label1,label3,formattedTextField2,"label3",cardLayout1,panel2);
        BaseButton buttonRight2 = new BaseButton("src/main/resources/images/rightArrow.png", label2,label1,label3,formattedTextField2,"label3",cardLayout1,panel2);

        frame.add(panelA);
        frame.add(panelB);

        panelA.add(panel1);
        panelA.add(panel2);
        panelB.add(panel3);
        panelB.add(panel4);

        // Add components to panel1,2
        panel1.add(buttonLeft1);
        panel1.add(label1);
        panel1.add(buttonRight1);
        panel2.add(formattedTextField1,"textField1");
        panel2.add(label3,"label3");

        // Add components to panel3,4
        panel3.add(formattedTextField2,"textField2");
        panel3.add(label4,"label4");
        panel4.add(buttonLeft2);
        panel4.add(label2);
        panel4.add(buttonRight2);

        frame.setVisible(true);

        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() ->{
                    label4.setText("0");
                    cardLayout2.show(panel3,"textField2");
                    panel3.requestFocusInWindow();
                });
            }
        });
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() ->{
                    label3.setText("0");
                    cardLayout1.show(panel2,"textField1");
                    panel4.requestFocusInWindow();
                });
            }
        });

        // Add DocumentListener to formattedTextField1
        formattedTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                DocumentUpdate.handleDocumentUpdate(formattedTextField1,label1,label2,label4,"label4",cardLayout2,panel3);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                DocumentUpdate.handleDocumentUpdate(formattedTextField1,label1,label2,label4,"label4",cardLayout2,panel3);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Called when the style of a character is changed
            }
        });

        // Add DocumentListener to formattedTextField2
        formattedTextField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                DocumentUpdate.handleDocumentUpdate(formattedTextField2,label1,label2,label3,"label3",cardLayout1,panel2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                DocumentUpdate.handleDocumentUpdate(formattedTextField2,label1,label2,label3,"label3",cardLayout1,panel2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Called when the style of a character is changed
            }
        });
    }
}