package pertemuan_4;

import javax.swing.*;  // Mengimpor library untuk GUI
import java.awt.event.*;  // Mengimpor library untuk menangani event keyboard

public class KeyListenerExample extends JFrame implements KeyListener {
    JLabel label;  // Label untuk menampilkan status event key
    JTextArea area;  // Text area tempat pengguna mengetik

    KeyListenerExample() {
        // Inisialisasi label dan mengatur posisi serta ukuran
        label = new JLabel();
        label.setBounds(20, 50, 100, 20);

        // Inisialisasi area teks dan mengatur posisi serta ukuran
        area = new JTextArea();
        area.setBounds(20, 80, 300, 300);
        area.addKeyListener(this);  // Menambahkan listener keyboard ke area teks

        // Menambahkan label dan area teks ke frame
        add(label);
        add(area);

        // Mengatur ukuran, layout, dan visibilitas frame
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Menutup aplikasi ketika frame ditutup
    }

    // Event ketika tombol ditekan
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed");
    }

    // Event ketika tombol dilepaskan
    public void keyReleased(KeyEvent e) {
        label.setText("Key Released");
    }

    // Event ketika tombol diketik (tekan + lepas)
    public void keyTyped(KeyEvent e) {
        label.setText("Key Typed");
    }

    public static void main(String[] args) {
        // Membuat instance dari KeyListenerExample dan menampilkan frame
        new KeyListenerExample();
    }
}
