package pertemuan_7;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class JenisMemberFrame extends JFrame {
    private JTextField idField, namaField;
    private JButton saveButton;

    public JenisMemberFrame() {
        setTitle("Jenis Member Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField(10);
        namaField = new JTextField(10);
        saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JenisMemberDao dao = new JenisMemberDao();
                JenisMember jenisMember = new JenisMember(idField.getText(), namaField.getText());
                try {
                    dao.addJenisMember(jenisMember);
                    JOptionPane.showMessageDialog(null, "Jenis Member Saved");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error saving data");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nama:"));
        panel.add(namaField);
        panel.add(saveButton);

        add(panel);
    }
}


