package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JButton exportButton;

    public UserView() {
        exportButton = new JButton("Export to PDF");
        add(exportButton);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserPdf userPdf = new UserPdf();
                userPdf.exportPdf();
                JOptionPane.showMessageDialog(null, "File PDF berhasil dibuat.");
            }
        });

        setLayout(new java.awt.FlowLayout());
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
