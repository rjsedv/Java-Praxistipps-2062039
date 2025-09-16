package de.rjs.finale;

//Datei: FinalizeDemo.java
public class FinalizeDemoTatsaechlicherAufruf {

 static class DemoObjekt {
     private String name;

     DemoObjekt(String name) {
         this.name = name;
     }

     @Override
     protected void finalize() throws Throwable {
         System.out.println("Finalize aufgerufen für Objekt: " + name);
     }
 }

 public static void main(String[] args) throws InterruptedException {
     System.out.println("Programmstart");

     DemoObjekt obj1 = new DemoObjekt("Objekt1");
     DemoObjekt obj2 = new DemoObjekt("Objekt2");

     // Objekte unerreichbar machen
     obj1 = null;
     obj2 = null;

     // Garbage Collector anstoßen (nur Hinweis)
     System.gc();

     // Kurze Pause, damit GC Zeit hat
     Thread.sleep(1000);

     System.out.println("Programmende");
 }
}
