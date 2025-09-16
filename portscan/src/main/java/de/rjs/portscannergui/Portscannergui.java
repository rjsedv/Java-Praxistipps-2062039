/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de.rjs.portscannergui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ralph
 */
public class Portscannergui
extends JFrame {

    private JTextField hostField;
    private JTextField portsField;
    private JButton scanButton;
    private JTextArea outputArea;

    private ExecutorService executor = Executors.newFixedThreadPool(50); // für parallele Scans

    public Portscannergui() {
        setTitle("Portscanner Swing");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel für Eingaben
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Host:"));
        hostField = new JTextField("127.0.0.1");
        inputPanel.add(hostField);

        inputPanel.add(new JLabel("Ports (z.B. 1-1024):"));
        portsField = new JTextField("1-1024");
        inputPanel.add(portsField);

        scanButton = new JButton("Scan starten");
        inputPanel.add(scanButton);

        add(inputPanel, BorderLayout.NORTH);

        // TextArea für Ausgabe
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button Action
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startScan();
            }
        });
    }

    private void startScan() {
        outputArea.setText("");
        String host = hostField.getText().trim();
        String portText = portsField.getText().trim();

        if (host.isEmpty() || portText.isEmpty()) {
            outputArea.append("Bitte Host und Portbereich eingeben.\n");
            return;
        }

        String[] parts = portText.split("-");
        int startPort, endPort;
        try {
            startPort = Integer.parseInt(parts[0]);
            endPort = Integer.parseInt(parts[1]);
        } catch (Exception e) {
            outputArea.append("Ungültiger Portbereich.\n");
            return;
        }

        for (int port = startPort; port <= endPort; port++) {
            int finalPort = port;
            executor.submit(() -> scanPort(host, finalPort));
        }
    }

    private void scanPort(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 200);
            appendText("Port " + port + " ist offen.\n");
        } catch (IOException ignored) {
            // Port geschlossen
        }
    }

    private void appendText(String text) {
        SwingUtilities.invokeLater(() -> outputArea.append(text));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Portscannergui scanner = new Portscannergui();
            scanner.setVisible(true);
        });
    }
}
