package de.rjs.speicherverwaltung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Aktuelles Verzeichnis ermitteln
        String currentDir = System.getProperty("user.dir");
        System.out.println("Aktuelles Verzeichnis: " + currentDir);

        // Datei im aktuellen Verzeichnis
        File file = new File(currentDir, "aufrufparameter.txt");

        // Prüfen, ob die Datei existiert
        if (!file.exists()) {
            System.err.println("Datei nicht gefunden: " + file.getAbsolutePath());
            return;
        }

        // Datei mit try-with-resources öffnen
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            System.out.println("Erste Zeile: " + line);
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
        // reader.close() wird automatisch aufgerufen
    }
}
