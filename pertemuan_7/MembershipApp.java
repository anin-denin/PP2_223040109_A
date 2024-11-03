package pertemuan_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MembershipApp extends JFrame {
    private JTextField idField, namaField;
    private JButton saveButton;

    public MembershipApp() {
        // Set up the JFrame
        setTitle("Jenis Member Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create text fields and button
        idField = new JTextField(15);
        namaField = new JTextField(15);
        saveButton = new JButton("Save");

        // Add components to JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nama:"));
        panel.add(namaField);
        panel.add(saveButton);

        add(panel);

        // ActionListener for the Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String nama = namaField.getText();
                simulateSaveJenisMember(id, nama);
            }
        });
    }

    private void simulateSaveJenisMember(String id, String nama) {
        // Simulate saving to a database by showing a confirmation message
        JOptionPane.showMessageDialog(this, "Simulated save: ID = " + id + ", Nama = " + nama);
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MembershipApp().setVisible(true);
            }
        });
    }
}

