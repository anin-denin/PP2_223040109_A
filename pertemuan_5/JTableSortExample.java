package pertemuan_5;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableSortExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Sorting Example");

        // Mendefinisikan nama kolom
        String[] columnNames = { "ID", "Name", "Age" };
        
        // Mendefinisikan data untuk tabel
        Object[][] data = {
            { 1, "John", 25 },
            { 3, "Mike", 35 },
            { 2, "Anna", 30 },
        };
        
        // Membuat model tabel dengan data dan nama kolom
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Membuat JTable dengan model
        JTable table = new JTable(model);
        
        // Mengaktifkan pengurutan otomatis
        table.setAutoCreateRowSorter(true);
        
        // Membuat JScrollPane untuk menampung JTable
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Menambahkan JScrollPane ke frame
        frame.add(scrollPane);
        
        // Mengatur konfigurasi frame
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

