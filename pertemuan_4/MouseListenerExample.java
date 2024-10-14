package pertemuan_4;

import javax.swing.*;  // Mengimpor library untuk GUI
import java.awt.event.*;  // Mengimpor library untuk menangani event mouse

public class MouseListenerExample extends JFrame implements MouseListener {
    JLabel label;  // Label untuk menampilkan teks berdasarkan event mouse

    MouseListenerExample() {
        // Inisialisasi label dan mengatur posisi serta ukuran
        label = new JLabel();
        label.setBounds(20, 50, 100, 20);
        add(label);  // Menambahkan label ke frame

        // Menambahkan listener mouse ke frame ini
        addMouseListener(this);

        // Mengatur ukuran, layout, dan visibilitas frame
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Menutup aplikasi ketika frame ditutup
    }

    // Event ketika mouse diklik
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked");
    }

    // Event ketika mouse masuk ke area frame
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered");
    }

    // Event ketika mouse keluar dari area frame
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited");
    }

    // Event ketika mouse ditekan
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed");
    }

    // Event ketika mouse dilepaskan
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released");
    }

    public static void main(String[] args) {
        // Membuat instance dari MouseListenerExample dan menampilkan frame
        new MouseListenerExample();
    }
}
