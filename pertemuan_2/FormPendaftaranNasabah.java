package pertemuan_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FormPendaftaranNasabah extends JFrame {

    // Komponen GUI
    private JList<String> listTabungan;
    private JSpinner spinnerTransaksi;
    private JPasswordField passwordField, confirmPasswordField;
    private JSpinner spinnerTanggalLahir;
    private JTextArea outputArea;

    public FormPendaftaranNasabah() {
        setTitle("Form Pendaftaran Nasabah Bank");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Input
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        // 1. JList untuk memilih jenis tabungan
        String[] tabunganList = {"Tabungan Reguler", "Tabungan Bisnis", "Tabungan Haji", "Tabungan Pelajar"};
        listTabungan = new JList<>(tabunganList);
        JScrollPane scrollPane = new JScrollPane(listTabungan);
        inputPanel.add(new JLabel("Jenis Tabungan:"));
        inputPanel.add(scrollPane);

        // 2. JSpinner untuk input frekuensi transaksi
        SpinnerModel modelTransaksi = new SpinnerNumberModel(1, 1, 100, 1); // min 1, max 100
        spinnerTransaksi = new JSpinner(modelTransaksi);
        inputPanel.add(new JLabel("Frekuensi Transaksi:"));
        inputPanel.add(spinnerTransaksi);

        // 3. JPasswordField untuk input password
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("Konfirmasi Password:"));
        inputPanel.add(confirmPasswordField);

        // 4. JSpinner untuk input tanggal lahir
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
        spinnerTanggalLahir = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        inputPanel.add(new JLabel("Tanggal Lahir:"));
        inputPanel.add(spinnerTanggalLahir);

        add(inputPanel, BorderLayout.CENTER);

        // Area Output
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        add(outputScrollPane, BorderLayout.SOUTH);

        // Panel Button
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.NORTH);

        // 5. MenuBar untuk Reset dan Exit
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(e -> resetForm());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    // Fungsi untuk Reset Form
    private void resetForm() {
        listTabungan.clearSelection();
        spinnerTransaksi.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        spinnerTanggalLahir.setValue(new Date());
        outputArea.setText("");
    }

    // Listener untuk tombol Submit
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTabungan = listTabungan.getSelectedValue();
            int transaksiPerBulan = (int) spinnerTransaksi.getValue();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();

            // Cek apakah password cocok
            if (!password.equals(confirmPassword)) {
                outputArea.setText("Password tidak cocok!");
            } else {
                // Menampilkan output form
                outputArea.setText("Jenis Tabungan: " + selectedTabungan + "\n" +
                        "Frekuensi Transaksi per Bulan: " + transaksiPerBulan + "\n" +
                        "Password: " + "*****" + "\n" +  // Password tidak ditampilkan
                        "Tanggal Lahir: " + tanggalLahir.toString() + "\n" +
                        "Pendaftaran berhasil!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormPendaftaranNasabah().setVisible(true);
        });
    }
}
