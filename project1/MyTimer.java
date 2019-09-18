package project1;

import javax.swing.*;


public class MyTimer {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Abigail McDonald Count Down Timer!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        My3Panels panel = new My3Panels();
        frame.getContentPane().add(panel);

        frame.setSize(1500, 1500);
        frame.setVisible(true);

    }

}
