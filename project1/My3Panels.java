package project1;

import javax.swing.*;


public class My3Panels extends JPanel {

    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public My3Panels(){
        p1 = new MyTimerPanel();
        p2 = new MyTimerPanel();
        p3 = new MyTimerPanel();

        add(p1);
        add(p2);
        add(p3);
    }
}
