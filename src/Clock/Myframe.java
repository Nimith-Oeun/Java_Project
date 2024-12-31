package Clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Myframe extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;// Format the time
    SimpleDateFormat dayFormat;// Format the day
    SimpleDateFormat dateFormat;// Format the date
    JLabel timeLabel , dayLabel, dateLabel;
    String time;
    String day;
    String date;

    Myframe() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setLayout(new FlowLayout());
        this.setResizable(false);// Prevent resizing
        this.setLocationRelativeTo(null);// Center the frame
        this.getContentPane().setBackground(new Color(0051));
        this.setTitle("Clock");


        timeFormat = new SimpleDateFormat("HH:mm:ss a");// Format the time
        dayFormat = new SimpleDateFormat("EEEE");// Format the day
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");// Format the date

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
        dateLabel.setForeground(Color.WHITE);


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
