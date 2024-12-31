import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.io.InputStreamReader;

public class MainFrame extends JFrame {
    private JButton startButton;
    private JTextArea textArea;

    public MainFrame() {
        setTitle("REST API Data Downloader");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        startButton = new JButton("Mulai");
        textArea = new JTextArea();
        textArea.setEditable(false);

        startButton.addActionListener(e -> downloadData());

        add(startButton, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void downloadData() {
        new Thread(() -> {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://672fbf9066e42ceaf15e9a9b.mockapi.io/api/contacts");
                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    JSONParser parser = new JSONParser();
                    JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(entity.getContent()));
                    StringBuilder result = new StringBuilder();

                    for (Object obj : jsonArray) {
                        JSONObject jsonObject = (JSONObject) obj;
                        result.append(jsonObject.toJSONString()).append("\n");
                    }

                    textArea.setText(result.toString());
                }

                EntityUtils.consume(entity);
                response.close();
                httpClient.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}