package pertemuan_3;

import javax.swing.*;
import java.awt.*;

public class Latihan1 extends JFrame {

    public Latihan1() {
        // Set the title of the window
        setTitle("Apakah ibukota Indonesia?");

        // Set BorderLayout for the JFrame
        setLayout(new BorderLayout());

        // Create buttons for different city names
        JButton btnJakarta = new JButton("Jakarta");
        JButton btnBandung = new JButton("Bandung");
        JButton btnSurabaya = new JButton("Surabaya");

        // Create a button for answering the question
        JButton btnAnswer = new JButton("Jawab pertanyaan di atas");

        // Add components to the BorderLayout
        add(new JLabel("Apakah ibukota Indonesia?", JLabel.CENTER), BorderLayout.NORTH);
        add(btnJakarta, BorderLayout.WEST);
        add(btnBandung, BorderLayout.CENTER);
        add(btnSurabaya, BorderLayout.EAST);
        add(btnAnswer, BorderLayout.SOUTH);

        // Set window size
        setSize(400, 200);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Run the application in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan1 h = new Latihan1();
                h.setVisible(true);
            }
        });
    }
}
