/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.dirorganize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFilesGUI extends JFrame {

    private JTextField extensionField;
    private JTextField targetDirField;
    private JTextField sourceDirField;
    private JTextArea logArea;

    public MoveFilesGUI() {
        setTitle("Dateien nach Erweiterung verschieben");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel für Eingaben
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 3, 5, 5));

        // Quellverzeichnis
        inputPanel.add(new JLabel("Zu durchsuchendes Verzeichnis:"));
        sourceDirField = new JTextField();
        inputPanel.add(sourceDirField);
        JButton browseSourceBtn = new JButton("Durchsuchen");
        browseSourceBtn.addActionListener(this::browseSourceDir);
        inputPanel.add(browseSourceBtn);

        // Dateierweiterung
        inputPanel.add(new JLabel("Dateierweiterung (z.B. txt):"));
        extensionField = new JTextField();
        inputPanel.add(extensionField);
        inputPanel.add(new JLabel()); // Platzhalter

        // Zielverzeichnis
        inputPanel.add(new JLabel("Name des Zielverzeichnisses:"));
        targetDirField = new JTextField();
        inputPanel.add(targetDirField);
        inputPanel.add(new JLabel()); // Platzhalter

        // Verschieben-Button
        JButton moveButton = new JButton("Dateien verschieben");
        moveButton.addActionListener(this::moveFiles);
        inputPanel.add(moveButton);

        add(inputPanel, BorderLayout.NORTH);

        // Log-Bereich
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void browseSourceDir(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            sourceDirField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void moveFiles(ActionEvent e) {
        String sourceDirPath = sourceDirField.getText().trim();
        String extension = extensionField.getText().trim();
        String targetDirName = targetDirField.getText().trim();

        if (sourceDirPath.isEmpty() || extension.isEmpty() || targetDirName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen.");
            return;
        }

        File sourceDir = new File(sourceDirPath);
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            JOptionPane.showMessageDialog(this, "Ungültiges Quellverzeichnis.");
            return;
        }

        File targetDir = new File(sourceDir, targetDirName);
        if (!targetDir.exists()) {
            if (!targetDir.mkdir()) {
                JOptionPane.showMessageDialog(this, "Konnte Zielverzeichnis nicht erstellen.");
                return;
            }
        }

        File[] files = sourceDir.listFiles((dir, name) -> name.endsWith("." + extension));

        if (files == null || files.length == 0) {
            logArea.append("Keine Dateien mit der Erweiterung ." + extension + " gefunden.\n");
            return;
        }

        for (File file : files) {
            Path sourcePath = file.toPath();
            Path targetPath = targetDir.toPath().resolve(file.getName());
            try {
                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                logArea.append("Verschoben: " + file.getName() + "\n");
            } catch (IOException ex) {
                logArea.append("Fehler beim Verschieben von " + file.getName() + ": " + ex.getMessage() + "\n");
            }
        }

        logArea.append("Fertig!\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MoveFilesGUI gui = new MoveFilesGUI();
            gui.setVisible(true);
        });
    }
}
