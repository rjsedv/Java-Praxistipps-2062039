package de.rjs.speicherverwaltung;

import java.lang.ref.Cleaner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GCDemoTimer {
    private static final Cleaner cleaner = Cleaner.create();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    static class Dummy {
        private final int id;

        Dummy(int id) {
            this.id = id;
            cleaner.register(this, () -> {
                System.out.println("Cleaner aufgerufen für Objekt " + id + " @ " + System.currentTimeMillis());
            });
        }
    }

    public static void main(String[] args) {
        // Schleife mit zeitverzögerter Objekterzeugung
        for (int i = 0; i < 20; i++) {
            final int id = i;
            scheduler.schedule(() -> {
                new Dummy(id);
                System.out.println("System.gc() aufgerufen für Objekt " + id + " @ " + System.currentTimeMillis());
                System.gc();
            }, i * 500, TimeUnit.MILLISECONDS); // Verzögerung i*500ms
        }

        // Scheduler nach Abschluss herunterfahren
        scheduler.schedule(() -> scheduler.shutdown(), 20 * 500 + 1000, TimeUnit.MILLISECONDS);
    }
}
