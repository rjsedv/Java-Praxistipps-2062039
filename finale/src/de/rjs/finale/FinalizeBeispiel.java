package de.rjs.finale;

public class FinalizeBeispiel {
	// Seit Java 9 ist finalize() veraltet
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize wurde aufgerufen!");
    }

    public static void main(String[] args) {
        FinalizeBeispiel obj = new FinalizeBeispiel();
        obj = null; 
        System.gc(); // Hinweis an die JVM: Garbage Collector ausführen
        System.out.println("Programmende");
    }
}
