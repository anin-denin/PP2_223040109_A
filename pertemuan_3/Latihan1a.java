package pertemuan_3;

import java.awt.*;
import javax.swing.*;

public class Latihan1a {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello GridLayout");
        frame.setLayout(new GridLayout(3, 3)); // 3 rows, 3 columns

        for (int i = 1; i <= 9; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
