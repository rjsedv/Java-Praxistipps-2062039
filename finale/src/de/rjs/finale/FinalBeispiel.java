package de.rjs.finale;


final class Tier {                         
 public static final int ANZAHL_BEINE = 4; // echte Konstante (statisch, final, großgeschrieben)

 final void laufen() {                     // darf NICHT überschrieben werden
     System.out.println("Das Tier läuft auf " + ANZAHL_BEINE + " Beinen.");
 }
}

public class FinalBeispiel {
 public static void main(String[] args) {
     System.out.println("Konstante: " + Tier.ANZAHL_BEINE);
     new Tier().laufen();
 }
}
