/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.rjs.dirorganize;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFilesByExtension {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java MoveFilesByExtension <sourceDirectory> <extension> <targetDirectory>");
            return;
        }

        String sourceDirName = args[0];
        String extension = args[1];
        String targetDirName = args[2];

        File sourceDir = new File(sourceDirName);
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Fehler: Das angegebene Quellverzeichnis existiert nicht oder ist kein Verzeichnis.");
            return;
        }

        File targetDir = new File(sourceDir, targetDirName);

        // Zielverzeichnis erstellen, falls es nicht existiert
        if (!targetDir.exists()) {
            if (!targetDir.mkdir()) {
                System.out.println("Fehler: Konnte Zielverzeichnis nicht erstellen.");
                return;
            }
        }

        File[] files = sourceDir.listFiles((dir, name) -> name.endsWith("." + extension));

        if (files == null || files.length == 0) {
            System.out.println("Keine Dateien mit der Erweiterung ." + extension + " gefunden.");
            return;
        }

        for (File file : files) {
            Path sourcePath = file.toPath();
            Path targetPath = targetDir.toPath().resolve(file.getName());
            try {
                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Verschoben: " + file.getName());
            } catch (IOException e) {
                System.out.println("Fehler beim Verschieben von " + file.getName() + ": " + e.getMessage());
            }
        }
    }
}
