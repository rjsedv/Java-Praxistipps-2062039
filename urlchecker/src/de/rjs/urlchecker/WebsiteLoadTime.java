/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.urlchecker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteLoadTime {
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
                long startTime = System.currentTimeMillis();

                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int code = connection.getResponseCode();

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;

                System.out.println(url + " -> Status: " + code + ", Ladezeit: " + duration + " ms");

            } catch (IOException e) {
                System.out.println(url + " -> Fehler: " + e.getMessage());
            }
        }
    }
}
