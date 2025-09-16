/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.ipscanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class DetailedIPScanner {

    public static void main(String[] args) {
        //String baseIP = "192.168.188."; // Typische Basis für IPs in einem lokalen C-Netz
        String baseIP = "10.217.99."; // Mögliche Basis für IPs in einem C-Netz, das mit Tethering aufgebaut wird

        int start = 1;
        int end = 254;

        System.out.println("Starte Scan von " + baseIP + start + " bis " + baseIP + end);

        for (int i = start; i <= end; i++) {
            String ip = baseIP + i;
            try {
                InetAddress inet = InetAddress.getByName(ip);
                if (inet.isReachable(500)) { // Timeout in ms
                    System.out.println("=========================================");
                    System.out.println("IP-Adresse: " + inet.getHostAddress());
                    System.out.println("Hostname: " + inet.getHostName());
                    System.out.println("Erreichbar: ja");

                    // MAC-Adresse nur lokal möglich (falls IP lokal ist)
                    if (inet.isLoopbackAddress() || inet.isAnyLocalAddress()) {
                        try {
                            NetworkInterface ni = NetworkInterface.getByInetAddress(inet);
                            if (ni != null) {
                                byte[] mac = ni.getHardwareAddress();
                                if (mac != null) {
                                    StringBuilder sb = new StringBuilder();
                                    for (int j = 0; j < mac.length; j++) {
                                        sb.append(String.format("%02X%s", mac[j], (j < mac.length - 1) ? "-" : ""));
                                    }
                                    System.out.println("MAC-Adresse: " + sb);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("MAC-Adresse konnte nicht ermittelt werden.");
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(ip + " ist nicht erreichbar.");
            }
        }

        System.out.println("Scan abgeschlossen.");
    }
}
