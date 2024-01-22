package org.example;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        BaseFrame frame = new BaseFrame();

        BasePanel panelA = new BasePanel(Color.WHITE,new GridLayout(2,1));
        BasePanel panelB = new BasePanel(Color.WHITE,new GridLayout(2,1));
        BasePanel panel1 = new BasePanel(new Color(255, 82, 82),new GridLayout(1,3));
        BasePanel panel2 = new BasePanel(new Color(255, 82, 82),new BorderLayout());
        BasePanel panel3 = new BasePanel(Color.WHITE,new BorderLayout());
        BasePanel panel4 = new BasePanel(Color.WHITE,new GridLayout(1,3));

        BaseLabel label1 = new BaseLabel("CELSIUS", Color.white);
        BaseLabel label2 = new BaseLabel("FAHRENHEIT", new Color(255, 82, 82));

        BaseButton buttonLeft1 = new BaseButton("src/main/resources/images/leftArrow.png", label1);
        BaseButton buttonRight1 = new BaseButton("src/main/resources/images/rightArrow.png", label1);

        BaseButton buttonLeft2 = new BaseButton("src/main/resources/images/leftArrow.png", label2);
        BaseButton buttonRight2 = new BaseButton("src/main/resources/images/rightArrow.png", label2);

        BaseTextField textField1 = new BaseTextField(new Color(255, 82, 82),Color.WHITE);
        BaseTextField textField2 = new BaseTextField(Color.WHITE,new Color(255, 82, 82));

        frame.add(panelA);
        frame.add(panelB);

        panelA.add(panel1);
        panelA.add(panel2);
        panelB.add(panel3);
        panelB.add(panel4);

        // Add components to panel1,2 with GridLayout
        panel1.add(buttonLeft1);
        panel1.add(label1);
        panel1.add(buttonRight1);
        panel2.add(textField1,BorderLayout.CENTER);

        // Add components to panel3,4 with GridLayout
        panel3.add(textField2,BorderLayout.CENTER);
        panel4.add(buttonLeft2);
        panel4.add(label2);
        panel4.add(buttonRight2);

        frame.setVisible(true);
    }
}