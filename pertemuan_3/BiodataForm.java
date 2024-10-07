package pertemuan_3;

import javax.swing.*;
import java.awt.*;

public class BiodataForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Biodata Form");
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Age:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Address:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(new JTextField());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Submit"));
        buttonPanel.add(new JButton("Reset"));

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
