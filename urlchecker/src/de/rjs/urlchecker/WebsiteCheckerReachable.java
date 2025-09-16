/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.urlchecker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebsiteCheckerReachable {
    public static void main(String[] args) {
        // Pfad zur Textdatei im selben Verzeichnis wie die Class-Datei
        String currentDir = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParent();
        String inputFile = currentDir + File.separator + "websites.txt";
        String outputFile = currentDir + File.separator + "results.txt";

        List<String> urls = readUrlsFromFile(inputFile);

        if (urls.isEmpty()) {
            System.out.println("Keine URLs gefunden.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (String url : urls) {
                try {
                    long startTime = System.currentTimeMillis();

                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000); // Timeout 5 Sekunden
                    connection.setReadTimeout(5000);
                    connection.connect();
                    int code = connection.getResponseCode();

                    long endTime = System.currentTimeMillis();
                    long duration = endTime - startTime;

                    if (code == 200) {
                        String result = url + " -> erreichbar (Status 200), Ladezeit: " + duration + " ms";
                        System.out.println(result);
                        writer.println(result);
                    }

                } catch (IOException e) {
                    // Fehlerhafte oder nicht erreichbare Seiten werden ignoriert
                }
            }
            System.out.println("Ergebnisse gespeichert in: " + outputFile);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }

    private static List<String> readUrlsFromFile(String filename) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    urls.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Einlesen der Datei: " + e.getMessage());
        }
        return urls;
    }
}
