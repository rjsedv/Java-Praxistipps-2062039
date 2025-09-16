/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.rjs.urlchecker;

/**
 *
 * @author ralph
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteChecker {
    public static void main(String[] args) {
        String[] urls = {
            "https://www.google.com",
            "https://www.example.com/404page",
            "https://www.openai.com",
            "https://rjs.de",
            "https://blog.rjs.de"
        };
        for (String url : urls) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int code = connection.getResponseCode();
                if (code == 200) {
                    System.out.println(url + " ist erreichbar (Status 200).");
                } else if (code == 404) {
                    System.out.println(url + " nicht gefunden (Status 404).");
                } else {
                    System.out.println(url + " liefert Status: " + code);
                }

            } catch (IOException e) {
                System.out.println("Fehler beim Check von " + url  + e.getMessage());
            }
        }
    }
}
