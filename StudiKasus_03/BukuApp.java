package StudiKasus_03;

import javax.swing.*;
import java.awt.*;

public class BukuApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistem Pengelolaan Buku");
        JMenuBar menuBar = new JMenuBar();

        // Menu dan Item
        JMenu menuFile = new JMenu("File");
        JMenu menuForm = new JMenu("Form");
        JMenuItem menuTambahBuku = new JMenuItem("Tambah Buku");

        // Menambahkan ke MenuBar
        menuForm.add(menuTambahBuku);
        menuBar.add(menuFile);
        menuBar.add(menuForm);
        frame.setJMenuBar(menuBar);

        // Panel Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2));

        // JTextField
        formPanel.add(new JLabel("Judul Buku:"));
        JTextField judulField = new JTextField();
        formPanel.add(judulField);

        // JTextArea
        formPanel.add(new JLabel("Deskripsi:"));
        JTextArea deskripsiArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(deskripsiArea));

        // JRadioButton
        formPanel.add(new JLabel("Jenis Buku:"));
        JRadioButton fiksi = new JRadioButton("Fiksi");
        JRadioButton nonFiksi = new JRadioButton("Non-Fiksi");
        ButtonGroup jenisGroup = new ButtonGroup();
        jenisGroup.add(fiksi);
        jenisGroup.add(nonFiksi);
        JPanel radioPanel = new JPanel();
        radioPanel.add(fiksi);
        radioPanel.add(nonFiksi);
        formPanel.add(radioPanel);

        // JCheckBox
        formPanel.add(new JLabel("Status:"));
        JCheckBox baruCheckBox = new JCheckBox("Buku Baru");
        formPanel.add(baruCheckBox);

        // JComboBox
        formPanel.add(new JLabel("Genre:"));
        JComboBox<String> genreCombo = new JComboBox<>(new String[]{"Novel", "Sejarah", "Sains"});
        formPanel.add(genreCombo);

        // JList
        formPanel.add(new JLabel("Daftar Buku:"));
        JList<String> bukuList = new JList<>(new DefaultListModel<>());
        formPanel.add(new JScrollPane(bukuList));

        // JSlider dan JSpinner (Bonus)
        formPanel.add(new JLabel("Rating:"));
        JSlider ratingSlider = new JSlider(1, 5, 3);
        formPanel.add(ratingSlider);
        formPanel.add(new JLabel("Jumlah Halaman:"));
        JSpinner halamanSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        formPanel.add(halamanSpinner);

        // Frame Setting
        frame.add(formPanel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
