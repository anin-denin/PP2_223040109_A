package pertemuan_3;

import java.awt.*;
import javax.swing.*;

public class HelloFlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello FlowLayout");
        frame.setLayout(new FlowLayout());

        for (int i = 1; i <= 5; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

