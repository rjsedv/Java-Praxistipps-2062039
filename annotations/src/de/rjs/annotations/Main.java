package de.rjs.annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        EigeneAnnotations demo = new EigeneAnnotations();
        Method[] methods = EigeneAnnotations.class.getDeclaredMethods();
        
        for (Method method : methods) {
            // Prüfen, ob Methode mit @RunMe annotiert ist
            if (method.isAnnotationPresent(RunMe.class)) {
                RunMe annotation = method.getAnnotation(RunMe.class);
                System.out.println("Führe Methode aus: " + method.getName() + " (" + annotation.info() + ")");
                method.invoke(demo); // Methode aufrufen
            }
        }
    }
}
