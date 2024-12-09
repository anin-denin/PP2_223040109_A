
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import database.DatabaseConnection;


public class Studi_Kasus2 extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Studi_Kasus2() {
        setTitle("CRUD dengan JDBC");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Membuat table model
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Telepon");
        model.addColumn("Email");

        // Membuat tabel untuk menampilkan data
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel untuk form
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); // Menata form secara vertikal

        JLabel labelNama = new JLabel("Nama:");
        JTextField txtNama = new JTextField();
        JLabel labelAlamat = new JLabel("Alamat:");
        JTextField txtAlamat = new JTextField();
        JLabel labelTelepon = new JLabel("Telepon:");
        JTextField txtTelepon = new JTextField();
        JLabel labelEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        panel.add(labelNama);
        panel.add(txtNama);
        panel.add(labelAlamat);
        panel.add(txtAlamat);
        panel.add(labelTelepon);
        panel.add(txtTelepon);
        panel.add(labelEmail);
        panel.add(txtEmail);

        // Tombol Insert, Update, Delete
        JButton btnInsert = new JButton("Insert");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnInsert);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners untuk tombol
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String alamat = txtAlamat.getText();
                String telepon = txtTelepon.getText();
                String email = txtEmail.getText();

                // Validasi input
                if (nama.isEmpty() || alamat.isEmpty() || telepon.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
                } else {
                    insertData(nama, alamat, telepon, email);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    String nama = txtNama.getText();
                    String alamat = txtAlamat.getText();
                    String telepon = txtTelepon.getText();
                    String email = txtEmail.getText();
                    updateData(nama, alamat, telepon, email);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data untuk diupdate");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    deleteData();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data untuk dihapus");
                }
            }
        });
    }

    // Insert data ke database
    private void insertData(String nama, String alamat, String telepon, String email) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO contact (nama, alamat, telepon, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            stmt.setString(4, email);
            stmt.executeUpdate();
            loadData(); // reload data
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update data di database
    private void updateData(String nama, String alamat, String telepon, String email) {
        try (Connection con = DatabaseConnection.getConnection()) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0); // Ambil ID dari baris yang dipilih

            String query = "UPDATE contact SET nama = ?, alamat = ?, telepon = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            stmt.setString(4, email);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            loadData(); // reload data
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete data dari database
    private void deleteData() {
        try (Connection con = DatabaseConnection.getConnection()) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0); // Ambil ID dari baris yang dipilih

            String query = "DELETE FROM contact WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            loadData(); // reload data
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Load data dari database ke JTable
    private void loadData() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM contact";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            model.setRowCount(0); // Clear table model
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("telepon"),
                        rs.getString("email")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Studi_Kasus2 frame = new Studi_Kasus2();
                frame.setVisible(true);
                frame.loadData(); // load data saat aplikasi dijalankan
            }
        });
    }
}
