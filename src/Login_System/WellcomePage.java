package Login_System;

import javax.swing.*;
import java.awt.*;

public class WellcomePage {
    JFrame frame = new JFrame();
    JLabel wellcomeLabel = new JLabel();
    WellcomePage(String userID) {
        wellcomeLabel.setBounds(0, 100, 400, 25);
        wellcomeLabel.setFont(new Font(null, Font.ITALIC, 25));
        wellcomeLabel.setText("Wellcome to " + userID);


        frame.add(wellcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
