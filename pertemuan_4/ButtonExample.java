package pertemuan_4;

import javax.swing.*;  // Mengimpor library untuk GUI
import java.awt.event.*;  // Mengimpor library untuk menangani event

public class ButtonExample {
    public static void main(String[] args) {
        // Membuat frame (jendela) dengan judul "Button Example"
        JFrame frame = new JFrame("Button Example");

        // Membuat tombol dengan teks "Click Here" dan menempatkannya di posisi tertentu
        JButton button = new JButton("Click Here");
        button.setBounds(50, 100, 95, 30);  // Mengatur posisi dan ukuran tombol

        // Menambahkan action listener pada tombol untuk mendeteksi klik
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menampilkan teks di console ketika tombol diklik
                System.out.println("Button clicked");
            }
        });

        // Menambahkan tombol ke frame (jendela)
        frame.add(button);

        // Mengatur ukuran frame dan layout, serta membuatnya terlihat
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        // Mengatur aksi ketika frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
