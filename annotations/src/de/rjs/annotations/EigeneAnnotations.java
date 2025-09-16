package de.rjs.annotations;

public class EigeneAnnotations {
   
    @RunMe(info = "Diese Methode wird ausgeführt")
    public void hello() {
        System.out.println("Hallo Welt!");
    }
    
    public void goodbye() {
        System.out.println("Auf Wiedersehen!");
    }
    
    @RunMe
    public void greet() {
        System.out.println("Willkommen!");
    }
}
