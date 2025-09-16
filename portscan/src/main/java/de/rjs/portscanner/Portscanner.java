/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de.rjs.portscanner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Portscanner {

    public static void main(String[] args) {
        //String host = "127.0.0.1"; // Zielhost - Loopback
        String host = "10.217.99.246"; // Zielhost - Loopback
        int startPort = 1;
        int endPort = 1024;

        System.out.println("Starte Scan von " + host + " von Port " + startPort + " bis " + endPort);

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), 200); // 200ms Timeout
                System.out.println("Port " + port + " ist offen.");
            } catch (IOException e) {
                // Port geschlossen oder nicht erreichbar
            }
        }

        System.out.println("Scan abgeschlossen.");
    }
}
