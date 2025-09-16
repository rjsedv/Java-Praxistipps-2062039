package de.rjs.speicherverwaltung;

import java.lang.ref.Cleaner;

public class GCDemoCleaner {
    // Ein globaler Cleaner
    private static final Cleaner cleaner = Cleaner.create();

    // Ressource, die aufgeräumt werden soll
    static class Dummy {
        private final int id;

        // Registrierung beim Cleaner: wenn Dummy vom GC eingesammelt wird,
        // wird die Cleanup-Action ausgeführt.
        Dummy(int id) {
            this.id = id;
            cleaner.register(this, () -> {
                System.out.println("Cleaner aufgerufen für Objekt " + id + " @ " + System.currentTimeMillis());
            });
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Dummy(i);
            System.out.println("System.gc() aufgerufen @ " + System.currentTimeMillis());
            System.gc(); // Anfrage an die JVM, GC zu starten
        }
    }
}
