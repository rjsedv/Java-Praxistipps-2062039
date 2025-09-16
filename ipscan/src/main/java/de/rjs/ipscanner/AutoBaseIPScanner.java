/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.ipscanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class AutoBaseIPScanner {

    public static void main(String[] args) {
        try {
            // Eigene lokale IP-Adresse ermitteln
            InetAddress localHost = getLocalInetAddress();
            if (localHost == null) {
                System.out.println("Konnte keine lokale IP-Adresse ermitteln.");
                return;
            }

            String localIP = localHost.getHostAddress();
            System.out.println("Lokale IP-Adresse: " + localIP);

            // Base-IP bestimmen (alle Oktette außer das letzte)
            String[] octets = localIP.split("\\.");
            if (octets.length != 4) {
                System.out.println("Ungültige IP-Adresse.");
                return;
            }
            String baseIP = octets[0] + "." + octets[1] + "." + octets[2] + ".";
            System.out.println("Base-IP für Scan: " + baseIP);

            int start = 1;
            int end = 254;

            System.out.println("Starte Scan von " + baseIP + start + " bis " + baseIP + end);

            for (int i = start; i <= end; i++) {
                String ip = baseIP + i;
                try {
                    InetAddress inet = InetAddress.getByName(ip);
                    if (inet.isReachable(200)) {
                        System.out.println(ip + " ist erreichbar.");
                    }
                } catch (IOException e) {
                    System.out.println(ip + " konnte nicht geprüft werden.");
                }
            }

            System.out.println("Scan abgeschlossen.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Methode zur Ermittlung der lokalen IP-Adresse (nicht 127.0.0.1)
    private static InetAddress getLocalInetAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                if (ni.isLoopback() || !ni.isUp())
                    continue;

                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (!addr.isLoopbackAddress() && addr.getHostAddress().indexOf(':') == -1) {
                        return addr;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
