package org.example;

public class Main {
    public static void main(String[] args) {
        BaseFrame frame = new BaseFrame();
        BaseLabel label1 = new BaseLabel("CELSIUS");
        BaseButton buttonLeft = new BaseButton("src/main/resources/images/leftArrow.png",label1);
        BaseButton buttonRight = new BaseButton("src/main/resources/images/rightArrow.png",label1);

        frame.add(buttonLeft);
        frame.add(buttonRight);
        frame.add(label1);

        frame.setVisible(true);


    }
}