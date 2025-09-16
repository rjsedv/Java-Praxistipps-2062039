package de.rjs.speicherverwaltung;

public class GCExample2 {


    static class Dummy {
        private final int id;

        Dummy(int id) {
            this.id = id;
        }

        @Override
        protected void finalize() {
            System.out.println("Finalize aufgerufen für Objekt " + id + " @ " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            // Objekt erzeugen und sofort "vergessen"
            new Dummy(i);

            // GC explizit anfordern
            System.out.println("System.gc() aufgerufen @ " + System.currentTimeMillis());
            System.gc();

            /*
             *  keine Pause! Viele System.gc()-Aufrufe direkt hintereinander.
			 *  finalize()-Meldungen kommen gar nicht, verspätet oder in Clustern, 
			 *  weil GC nicht synchron zu jedem Aufruf läuft. 
             */
            
        }
    }
}
