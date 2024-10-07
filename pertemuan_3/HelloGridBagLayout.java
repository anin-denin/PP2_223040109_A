package pertemuan_3;

import java.awt.*;
import javax.swing.*;

public class HelloGridBagLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello GridBagLayout");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(button1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(button2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(button4, gbc);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
