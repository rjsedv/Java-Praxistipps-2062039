/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.urlchecker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteCheckerWithSave {
    public static void main(String[] args) {
        String[] urls = {
            "https://www.google.com",
            "https://www.example.com/404page",
            "https://www.openai.com",
            "https://rjs.de",
            "https://blog.rjs.de"
        };

        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt"))) {
            for (String url : urls) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int code = connection.getResponseCode();
                    String result = url + " -> Status: " + code;
                    System.out.println(result);
                    writer.println(result);

                } catch (IOException e) {
                    String result = url + " -> Fehler: " + e.getMessage();
                    System.out.println(result);
                    writer.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
}
