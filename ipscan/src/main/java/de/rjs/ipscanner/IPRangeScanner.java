/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.ipscanner;

import java.io.IOException;
import java.net.InetAddress;

public class IPRangeScanner {

    public static void main(String[] args) {
        //String baseIP = "192.168.188."; // Typische Basis für IPs in einem lokalen C-Netz
        String baseIP = "10.217.99."; // Mögliche Basis für IPs in einem C-Netz, das mit Tethering aufgebaut wird
        int start = 1;  // Start der letzten Oktette
        int end = 254;  // Ende der letzten Oktette

        System.out.println("Starte Scan von " + baseIP + start + " bis " + baseIP + end);

        for (int i = start; i <= end; i++) {
            String ip = baseIP + i;
            try {
                InetAddress inet = InetAddress.getByName(ip);
                // Timeout in Millisekunden
                if (inet.isReachable(200)) {
                    System.out.println(ip + " ist erreichbar.");
                } else {
                   // System.out.println(ip + " ist nicht erreichbar.");
                }
            } catch (IOException e) {
                System.out.println(ip + " konnte nicht geprüft werden: " + e.getMessage());
            }
        }

        System.out.println("Scan abgeschlossen.");
    }
}
