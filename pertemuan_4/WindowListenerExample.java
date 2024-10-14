package pertemuan_4;

import java.awt.*;  // Mengimpor library untuk GUI
import java.awt.event.*;  // Mengimpor library untuk menangani event jendela (window)

public class WindowListenerExample extends Frame implements WindowListener {
    WindowListenerExample() {
        // Menambahkan listener jendela ke frame ini untuk mendeteksi event window
        addWindowListener(this);

        // Mengatur ukuran, layout, dan visibilitas frame
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    // Event ketika jendela diaktifkan (misalnya ketika aplikasi kembali fokus)
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    // Event ketika jendela ditutup (setelah proses menutup selesai)
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
    }

    // Event ketika jendela sedang ditutup (sebelum benar-benar tertutup)
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
        dispose();  // Menutup jendela
    }

    // Event ketika jendela dinonaktifkan (aplikasi kehilangan fokus)
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }

    // Event ketika jendela kembali dari ikon ke ukuran normal
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");
    }

    // Event ketika jendela diubah menjadi ikon (minimized)
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
    }

    // Event ketika jendela pertama kali dibuka
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
    }

    public static void main(String[] args) {
        // Membuat instance dari WindowListenerExample dan menampilkan frame
        new WindowListenerExample();
    }
}
