package de.rjs.finale;

//Datei: FinallySprungBeispiel.java
public class FinallySprungBeispiel {
 public static void main(String[] args) {
     System.out.println("=== Beispiel mit break ===");
     for (int i = 0; i < 3; i++) {
         try {
             System.out.println("Schleifendurchlauf " + i);
             if (i == 1) {
                 break; // Sprung aus der Schleife
             }
         } finally {
             System.out.println("finally bei i=" + i);
         }
     }

     System.out.println("\n=== Beispiel mit continue ===");
     for (int i = 0; i < 3; i++) {
         try {
             System.out.println("Schleifendurchlauf " + i);
             if (i == 1) {
                 continue; // Sprung zum nächsten Durchlauf
             }
         } finally {
             System.out.println("finally bei i=" + i);
         }
     }
 }
}
