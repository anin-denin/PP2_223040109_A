import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton startButton;
    private JProgressBar progressBar;

    public MainFrame() {
        setTitle("Konkurensi Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startButton = new JButton("Mulai");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLongTask();
            }
        });

        add(startButton, "North");
        add(progressBar, "South");
    }

    private void startLongTask() {
        // Menggunakan SwingWorker untuk menjalankan tugas berat
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 60; i++) {
                    Thread.sleep(1000); // Simulasi pemrosesan data
                    publish((i + 1) * 100 / 60); // Update progress
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                for (Integer value : chunks) {
                    progressBar.setValue(value);
                }
            }

            @Override
            protected void done() {
                JOptionPane.showMessageDialog(null, "Proses selesai!");
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
