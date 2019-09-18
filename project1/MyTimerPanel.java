
package project1;


import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyTimerPanel extends JPanel {
    private GeoCountDownTimer geoCountDownTimer;
    private GeoCountDownTimer geoCountDownTimer2;

    private Timer javaTimer;
    private TimerListener timer;
    private JLabel startDate;
    private JButton button;

    private JButton inc;
    private JButton dec;
    private JButton start;
    private JButton stop;
    private JButton enter;
    private JTextField value;

    private JButton save;
    private JButton load;
    private JButton daysToGo;
    private JButton daysInFuture;
    private JTextField FileName;

    private JLabel daytogo;
    private JLabel daytofuture;

    public MyTimerPanel() {
        geoCountDownTimer = new GeoCountDownTimer(12, 10, 2015);
        geoCountDownTimer2 = new GeoCountDownTimer(5, 12, 2015);
        timer = new TimerListener();

        start = new JButton("Start");
        stop = new JButton("Stop");
        enter = new JButton("Enter");
        inc = new JButton("Inc");
        dec = new JButton("Dec");
        save = new JButton("Save");
        load = new JButton("Load");
        daysToGo = new JButton("daysToGo");
        daysInFuture = new JButton("daysInFuture");

        startDate = new JLabel("                 ");
        daytogo = new JLabel("                 ");
        daytofuture = new JLabel("                 ");
        value = new JTextField("                    ");
        FileName = new JTextField("                    ");


        add(start);
        add(stop);
        add(enter);
        add(inc);
        add(dec);
        add(save);
        add(load);
        add(daysToGo);
        add(daysInFuture);
        add(new JLabel("Timer: "));
        add(startDate);
        add(new JLabel("Days to go: "));
        add(daytogo);
        add(new JLabel("Days in Future: "));
        add(daytofuture);
        add(new JLabel("Input Timer: "));
        add(value);
        add(new JLabel("Filename: "));
        add(FileName);
        start.addActionListener(new ButListener());
        stop.addActionListener(new ButListener());
        enter.addActionListener(new ButListener());
        inc.addActionListener(new ButListener());
        dec.addActionListener(new ButListener());
        save.addActionListener(new ButListener());
        load.addActionListener(new ButListener());
        daysToGo.addActionListener(new ButListener());
        daysInFuture.addActionListener(new ButListener());


        //make the buttons different colors
        start.setBackground(Color.GREEN);
        stop.setBackground(Color.RED);
        enter.setBackground(Color.CYAN);
        inc.setBackground(Color.GREEN);
        dec.setBackground(Color.RED);
        save.setBackground(Color.CYAN);
        load.setBackground(Color.CYAN);
        daysToGo.setBackground(Color.CYAN);
        daysInFuture.setBackground(Color.CYAN);


// this calls timer object 10 times per second
        javaTimer = new Timer(10, timer);  // 1000 * 60 * 60 * 24
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            geoCountDownTimer.inc();
            startDate.setText(geoCountDownTimer.toDateString());

            if (geoCountDownTimer.equals(new GeoCountDownTimer("1/1/2038"))) {
                System.out.println("Time is up!");
                javaTimer.stop();
            }
        }
    }

    private class ButListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (start == e.getSource())
                javaTimer.start();

            else if (stop == e.getSource())
                javaTimer.stop();

            else if (enter == e.getSource())
                geoCountDownTimer = new GeoCountDownTimer(value.getText().trim());

            else if (inc == e.getSource()) {
                geoCountDownTimer.inc();
                startDate.setText(geoCountDownTimer.toDateString());
            } else if (dec == e.getSource()) {
                geoCountDownTimer.dec();
                startDate.setText(geoCountDownTimer.toDateString());
            } else if (save == e.getSource()) {
                geoCountDownTimer.save(FileName.getText().trim());
            } else if (load == e.getSource()) {
                geoCountDownTimer.load(FileName.getText().trim());
            } else if (daysToGo == e.getSource()) {
                String intToString = Integer.toString(geoCountDownTimer.daysToGo(value.getText().trim()));
                daytogo.setText(intToString);


            } else if (daysInFuture == e.getSource()) {
                int n = Integer.parseInt(value.getText().trim());
                GeoCountDownTimer g = new GeoCountDownTimer(geoCountDownTimer.daysInFuture(n).toDateString());
                daytofuture.setText(g.toDateString());


            }


        }

    }
}