package pertemuan_1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("HelloWorldSwing");
        // Menambahkan teks ke dalam frame
        JLabel label = new JLabel("Hello Anin");
        frame.add(label);
        // Mengatur ukuran dan visibilitas
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
