package view;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class UserPdf {
    public void exportPdf() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("users.pdf"));
            document.open();
            document.add(new Paragraph("Laporan Data User"));
            document.add(new Paragraph("Data user berhasil diekspor ke file PDF."));
            // Tambahkan data user lain di sini
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
