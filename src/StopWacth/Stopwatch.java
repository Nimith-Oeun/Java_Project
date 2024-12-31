package StopWacth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    JFrame frame;
    JButton startButton= new JButton("Start");
    JButton stopButton= new JButton("Reset");
    JLabel timeLabel = new JLabel();
    JLabel titleLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);// used to format the seconds
    String minutes_string = String.format("%02d", minutes);// used to format the minutes
    String hours_string = String.format("%02d", hours);// used to format the hours
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1000;
            hours = (elapsedTime / 3600000); // 1 hour = 3600000 milliseconds
            minutes = (elapsedTime / 60000) % 60;// 1 minute = 60000 milliseconds
            seconds = (elapsedTime / 1000) % 60;// 1 second = 1000 milliseconds
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });
    Stopwatch() {
        titleLabel.setText("Stopwatch");
        titleLabel.setBounds(0, 0, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(JTextField.CENTER);
        titleLabel.setForeground(Color.GREEN);

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(0, 80, 400, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));// creates a border around the label
        timeLabel.setBackground(new Color(0051));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        startButton.setBounds(70, 250, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBackground(Color.GREEN);

        stopButton.setBounds(220, 250, 100, 50);
        stopButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        stopButton.setFocusable(false);
        stopButton.addActionListener(this);
        stopButton.setBackground(Color.ORANGE);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0051));
        frame.setLocationRelativeTo(null);//
        frame.setVisible(true);
        frame.add(titleLabel);
        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(stopButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if(started == false) {
                started = true;
                startButton.setText("Stop");
                startButton.setBackground(Color.RED);
                start();
            }else {
                started = false;
                startButton.setText("Start");
                startButton.setBackground(Color.GREEN);
                stop();
            }
        }
        if(e.getSource() == stopButton) {
            stop();
            started = false;
            startButton.setText("Start");
            reset();
        }
    }
    void start() {
        timer.start();

    }
    void stop() {
        timer.stop();
    }
    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
}
